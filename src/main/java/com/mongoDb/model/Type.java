package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "type")
@AllArgsConstructor
public class Type {
    private String typeName;
    private String category;
}
