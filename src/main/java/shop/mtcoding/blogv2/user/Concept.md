# 개요

client -> controller -> service -> repository -> persistence context -> DB

# User

User 객체를 다루기 위함 (전반적으로 사용)

# UserController

client에서 들어온 요청을 처리 (controller)

service DI 필요

# UserQueryRepository

실제 프로젝트에서 사용 X

# UserService

실제 비즈니스 로직 처리

repository DI 필요

# UserRepository

인터페이스이지만 영속성 콘텍스트 객체를 생성함

# UserRequest

유효성 검사 및 DTO 생성 (리다이렉션 시 데이터 전달)

DTO: 클라이언트의 정보를 가지고 있음(인증 정보)


