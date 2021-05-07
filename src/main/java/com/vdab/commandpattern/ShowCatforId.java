package com.vdab.commandpattern;

import com.vdab.domain.Category;
import com.vdab.services.CategoryService;

public class ShowCatforId implements Command{
    @Override
    public void execute() throws Exception {

        CategoryService categoryService= new CategoryService();

        Category category = categoryService.findCategoryOne();
        System.out.println("the category and the id are : " + category.getCategoryName() + " " + category.getId());
        System.out.println("-----------------------------------------------------------------");


    }
}
