package shop.mtcoding.blogv2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;  // DI 코드
    private final HttpSession session;

    @PostMapping("/user/update")
    public String update(@Valid UserRequest.PasswordUpdateDTO requestDTO, Errors errors) {
        return "redirect:/";
    }

    @PostMapping("/join")
    public String join(@Valid UserRequest.JoinDTO requestDTO, Errors errors) {
        System.out.println(requestDTO);
        userService.회원가입(requestDTO);
        // domain/h2-console
        return "redirect:/loginForm";
    }

    // request(가방): 클라이언트 요청마다 생성 -> 여러 개 생성
    // session(전체 락카): 필요할 때마다 DI 가능
    @PostMapping("/login")
    public String login(@Valid UserRequest.LoginDTO requestDTO, Errors errors) {
        User sessionUser = userService.로그인(requestDTO);
        session.setAttribute("sessionUser", sessionUser);
        // 로그인 시 세션 ID 생성 -> response로 클라이언트(브라우저)가 받음 -> setCookie 헤더에 저장
        // 개발자 도구 -> 요청 전송 -> 응답 확인 -> Application 탭에서 확인 가능
        // 재로그인 시 -> request 헤더에 세션 id를 받아서 로그인

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }
}
