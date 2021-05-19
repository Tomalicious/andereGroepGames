package com.vdab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity{

    private String categoryName;

    public Category(int id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }

}
