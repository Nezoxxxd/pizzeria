package com.modsen.pizzeria.controllers;

import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse createOrder(@RequestBody CreateCategoryRequest createCategoryRequest){return categoryService.createCategory(createCategoryRequest);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequest updateCategoryRequest){return categoryService.updateCategory(id,updateCategoryRequest);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id){categoryService.deleteCategory(id);}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
