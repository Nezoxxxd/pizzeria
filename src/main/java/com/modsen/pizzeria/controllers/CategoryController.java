package com.modsen.pizzeria.controllers;

import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
@Tag(name = "Category Controller", description = "Category API")
public class CategoryController {

     private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Category")
    public CategoryResponse createOrder(@RequestBody @Valid CreateCategoryRequest createCategoryRequest){
        return categoryService.createCategory(createCategoryRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update Category")
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid UpdateCategoryRequest updateCategoryRequest
    ){
        return categoryService.updateCategory(id,updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete Category")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Category by id")
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Categories")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
