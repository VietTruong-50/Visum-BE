package com.mongoDb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Permission {

    @Id
    private String id;

    private String name;

}
