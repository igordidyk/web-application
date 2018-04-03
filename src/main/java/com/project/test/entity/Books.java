package com.project.test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String published;
    @Setter
    @Getter
    private String gerne;
    @Setter
    @Getter
    private String rating;
    @Setter
    @Getter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "Books_Authors",
            inverseJoinColumns = @JoinColumn(name = "authors_id"),
            joinColumns = @JoinColumn(name = "books_id"))
    private List<Authors> authors;
}
