package com.nova.springSecurity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Integer roleId;
    private String authority;
    @Override
    public String getAuthority() {
        return this.authority;
    }
    public Role(String authority){
        this.authority=authority;
    }
}
