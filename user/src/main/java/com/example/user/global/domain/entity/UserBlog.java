package com.example.user.global.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "USER_BLOGS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class UserBlog implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USER_BLOG_ID")
    private UUID id;
    @Column(name = "USER_EMAIL", unique = true)
    private String email;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "BLOG_NAME")
    private String blogName;

    @Column(name="POST_ID")
    private UUID postId;

    @Column(name="NEIGHBOR_ID")
    @OneToMany(mappedBy = "userBlog", cascade = CascadeType.ALL)
    private List<Neighbor> neighbors;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"ROLE_USER");
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "email";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
