package com.mongoDb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Role {

    @Id
    private String id;

    private String name;

    @DBRef(lazy = true)
    private Set<User> users = new HashSet<>();

}
