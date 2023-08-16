# a. Cấu hình kết nối cơ sở dữ liệu:

```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>
```

- spring.datasource.url: Đây là URL để kết nối đến cơ sở dữ liệu MySQL. Ví dụ này cho thấy việc kết nối đến cơ sở dữ liệu có tên "tesst" trên máy localhost thông qua cổng 3306.
- spring.datasource.username: Đây là tên đăng nhập để truy cập cơ sở dữ liệu MySQL. Trong ví dụ này, tên người dùng là "root".
- spring.datasource.password: Đây là mật khẩu để truy cập cơ sở dữ liệu MySQL. Trong ví dụ này, mật khẩu được đặt là "@Anh123anh".

# b. Cấu hình JPA (Java Persistence API):

======================================================================================================================================================================

- spring.jpa.properties.hibernate.dialect: Đây là cấu hình cho loại dialect hibernate sử dụng. Trong ví dụ này, dialect cho MySQL được sử dụng.
- spring.jpa.hibernate.ddl-auto: Đây là cấu hình để xác định hành động thực hiện với schema cơ sở dữ liệu khi khởi động ứng dụng. Trong ví dụ này, sử dụng "update" để cập nhật cấu trúc bảng tự động dựa trên các thay đổi trong các entity.
  c. Cấu hình JWT (JSON Web Token):
- bezkoder.app.jwtSecret: Đây là cấu hình cho khóa bí mật được sử dụng để tạo và xác minh JSON Web Token (JWT). Trong ví dụ này, chuỗi "======================ThuanLV=LTS=Spring===========================" được sử dụng làm khóa bí mật.
- bezkoder.app.jwtExpirationMs: Đây là cấu hình cho thời gian tồn tại của JWT tính bằng mili giây. Trong ví dụ này, JWT sẽ hết hạn sau 86400000 mili giây (1 ngày).

# d. Cấu hình port cho ứng dụng Spring Boot:

– với MySQL:

- modelVersion: Đây là định dạng phiên bản POM được sử dụng. Trong trường hợp này, nó là "4.0.0".
- parent: Đây định nghĩa dự án cha của dự án hiện tại. Trong trường hợp này, nó là "spring-boot-starter-parent" của Spring Boot với phiên bản "3.1.0".
- groupId, artifactId, version, name, description: Đây là các thông tin cơ bản về dự án như tên nhóm dự án, tên dự án, phiên bản, tên dự án và mô tả.
- properties: Đây định nghĩa các thuộc tính được sử dụng trong dự án. Trong trường hợp này, nó chỉ định phiên bản Java được sử dụng là 17.
- dependencies: Đây là danh sách các dependency (thư viện) mà dự án sử dụng. Các dependency bao gồm các thư viện hỗ trợ Spring Data JPA, Spring Security, Spring Validation, phát triển ứng dụng web Spring Boot, kết nối cơ sở dữ liệu MySQL, JSON Web Token (JWT) và các dependency liên quan đến việc viết test cho ứng dụng.
- build: Đây định nghĩa các cấu hình liên quan đến quá trình build dự án. Trong trường hợp này, chỉ có plugin "spring-boot-maven-plugin" để hỗ trợ build ứng dụng Spring Boot.
- # Những thư viện này được quản lý thông qua Maven và sẽ tự động được tải xuống khi bạn build và chạy ứng dụng của mình. Maven sẽ tự động giải quyết các phụ thuộc này và đảm bảo rằng các thư viện cần thiết sẽ được sử dụng trong dự án của bạn.

# e. Sử dụng với PostMan

## Chạy các câu lệnh insert SQL sau để thêm sẵn quyền mặc định

```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

- đăng ký người dùng mới tại @PostMapping("/signup") với tham số chuyền vào là SignupRequest với các tham số truyền vào là email username password tại đây mặc định bạn phải thêm trực tiếp các trường ROLE_USER nhưng bạn hoàn toàn có thể sửa nó trong bảng user_roles.
- khi đăng nhập thì ta sẽ sử dụng router api của @PostMapping("/signin") và tham số chuyền vào nó là LoginRequest với username và password và nó sẽ trả về token với tương ứng với tài khoảng mà bạn đăng nhập.
- test thử các api bên phần testController và xem nó hoạt động như nào khi có token và khi không có token
