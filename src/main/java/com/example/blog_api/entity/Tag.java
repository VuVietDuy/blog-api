package com.example.blog_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, unique = true)
    private String name;

    //@Lob annotation is JPA(Java Persistence API) is used to mark a field or property of an entity class as
    //a Large Object(LOB) column in a db
    @Lob
    @Column(length = 1000000)
    private String description;

    @CreationTimestamp
    @Column(unique = false)
    private Date create_at;

    @JsonIgnore
    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

}
