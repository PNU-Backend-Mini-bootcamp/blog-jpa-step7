package shop.mtcoding.blogv2.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {

    @Data // getter, setter, toString
    public static class JoinDTO {
        @NotEmpty
        @Size(min = 3, max = 20)
        private String username;

        @NotEmpty
        @Size(min = 4, max = 20)
        private String password;

        @NotEmpty
        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;

        // 클라이언트에게 받은 정보를 Repository에게 전달하기 위해 Entity로 변환
        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
        }
    }

    @Data
    public static class LoginDTO {
        @NotEmpty
        @Size(min = 3, max = 20)
        private String username;

        @NotEmpty
        @Size(min = 4, max = 20)
        private String password;
    }

    @Data
    public static class PasswordUpdateDTO {
        @NotEmpty
        @Size(min = 4, max = 20)
        private String password;
    }
}
