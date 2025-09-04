package com.mahindra.userManagement.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_management")
@Data
public class UserMgmt implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"user_id\"")
    @GenericGenerator(
            name = "\"user_id\"",
            strategy = "com.mahindra.userManagement.model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "UR-")
            })
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;
    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;
    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;
    @Column(name = "city", nullable = false, length = Integer.MAX_VALUE)
    private String city;
    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

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
}