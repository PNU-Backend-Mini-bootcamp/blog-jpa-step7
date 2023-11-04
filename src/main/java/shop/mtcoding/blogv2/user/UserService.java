package shop.mtcoding.blogv2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.blogv2._core.error.ex.Exception401;

import javax.transaction.Transactional;

// 실제 프레임워크: EntityManager, UserController -(DI)-> UserService -(DI)-> UserRepository (-> Persistence Context -> DB)
// controller   | 사장 |   | 사장 |
// service      | 과장 |   | 과장 |
// repository   | 사원 | - | 사원 |

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO requestDTO) {
        userRepository.save(requestDTO.toEntity());
        // Exception 발생 시 roll-back 됨
    }   // 트랜잭션 종료 -> flush 발생

    // 단순 조회이기 때문에 @Transactional 필요 X
    public User 로그인(UserRequest.LoginDTO requestDTO) {
        User sessionUser =
                userRepository.login(requestDTO.getUsername(), requestDTO.getPassword());

        // 필터링 코드만 작성하기
        if (sessionUser == null) {
            throw new Exception401("아이디 혹은 패스워드가 틀렸습니다.");
        }
        return sessionUser;
    }
}
