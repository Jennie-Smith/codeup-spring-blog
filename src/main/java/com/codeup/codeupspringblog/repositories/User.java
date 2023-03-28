package com.codeup.codeupspringblog.repositories;
import jakarta.persistence.*;
import lombok. *;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="post_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=150, nullable = false)
    private String username;

    @Column(length=150, nullable = false)
    private String email;

    @Column(length=150, nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    @ToString.Exclude
    private List<Post> posts;

}