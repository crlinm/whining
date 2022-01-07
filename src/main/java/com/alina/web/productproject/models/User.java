package com.alina.web.productproject.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    public enum Role {
        ADMIN, USER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    @Column(unique = true)
    private String nickName;

    @Column(unique = true)
    private String email;
    private String hashPassword;

    @Column(columnDefinition = "text not null default ''")
    private String description;

    @OneToMany(mappedBy = "user")
    private Set<Whine> whines;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nickName, user.nickName) && Objects.equals(email, user.email) && Objects.equals(hashPassword, user.hashPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, email, hashPassword);
    }
}
