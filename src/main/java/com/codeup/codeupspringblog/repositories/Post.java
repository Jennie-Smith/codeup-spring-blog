package com.codeup.codeupspringblog.repositories;
import com.codeup.codeupspringblog.models.User;
import jakarta.persistence.*;
import lombok. *;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=150, nullable = false)
    private String title;

    @Column(length=254, nullable = false)
    private String body;

    @ManyToOne
    private User user;

}
