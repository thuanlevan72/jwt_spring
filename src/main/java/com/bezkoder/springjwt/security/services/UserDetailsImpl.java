package com.bezkoder.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.springjwt.models.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  // Constructor của lớp
  public UserDetailsImpl(Long id, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  // Tạo đối tượng UserDetailsImpl từ đối tượng User (được sử dụng trong
  // UserDetailsServiceImpl)
  public static UserDetailsImpl build(Account user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        authorities);
  }

  // Lấy danh sách các quyền của người dùng
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  // Trả về mật khẩu của người dùng
  @Override
  public String getPassword() {
    return password;
  }

  // Trả về tên đăng nhập của người dùng
  @Override
  public String getUsername() {
    return username;
  }

  // Các phương thức kiểm tra tính toàn vẹn của người dùng
  // Các phương thức này đều trả về true, nghĩa là người dùng luôn được coi là
  // "đang hoạt động" và "không bị khóa".
  // Đây chỉ là một ví dụ đơn giản, bạn có thể thay đổi logic kiểm tra tính toàn
  // vẹn theo yêu cầu của ứng dụng.
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  // Ghi đè phương thức equals để so sánh hai đối tượng UserDetailsImpl dựa trên
  // trường id của họ.
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
