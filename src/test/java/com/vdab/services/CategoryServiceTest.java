package com.vdab.services;

import com.vdab.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    //integration test : black box end to end test met 2 parameters : de verwachting en de waarde die echt uit de output komt

    private CategoryService categoryService = new CategoryService();

    @Test
    public void testThatFindCategoryOne(){
        Category foundCatergory = categoryService.findCategoryOne();
        Assertions.assertEquals("combination", foundCatergory.getCategoryName());
        Assertions.assertEquals(1,foundCatergory.getId());
    }

}