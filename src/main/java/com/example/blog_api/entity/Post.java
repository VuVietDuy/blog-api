package com.example.blog_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    //The @Entity annotation in JPA (Java Persistence API) is used to mark a Java class as an entity, which corresponds
    //to a table in a relational database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 1000)
    private String body;

    @Column(nullable = false, unique = false, length = 1000000)
    private String title;

    @Column(nullable = false, unique = false)
    private String titleURL;

    @CreationTimestamp
    @Column(nullable = true)
    private Date create_at;

    // @OneToMany annotation in JPA is used to establish a one-to-many relationship between two entities. It indicates that
    // one entity has a collection (or list) of another entity.
    //  - Use the mappedBy attribute to specify the field in the target entity that owns the relationship

    // @ManyToOne annotation is used to define a many-to-one(n-1) relationship between two entities. It indicates that multiple
    // instances of one entity can be associated with a single instance of another entity.
    //  - The fetch attribute is used to specify how the related entity should be fetched from the db when navigating a @ManyToOne
    //    relationship

    // @JoinColumn annotation in JPA is used to specify the mapping of a foreign key column in a relational database table.
    // It's often used in conjunction with the @ManyToOne, @OneToMany, @OneToOne annotations to define the relationship
    // between entities in a JPA-managed application

    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL , orphanRemoval = true)
    private List<FileUpload> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    // HashSet is a collection class in Java that implements the Set interface. It represents an unordered collection of
    // elements, where each element is unique (no duplicate values are allowed).
    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
}
