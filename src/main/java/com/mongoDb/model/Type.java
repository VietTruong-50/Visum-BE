package com.mongoDb.model;

import com.mongoDb.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Type {
    private TypeEnum typeName;
    private String category;
}
