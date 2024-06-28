package com.modsen.pizzeria.controllers;

import com.modsen.pizzeria.swagger.CategoryApi;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.service.CategoryService;
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
public class CategoryController implements CategoryApi {

     private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CategoryResponse createOrder(@RequestBody @Valid CreateCategoryRequest createCategoryRequest){
        return categoryService.createCategory(createCategoryRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid UpdateCategoryRequest updateCategoryRequest
    ){
        return categoryService.updateCategory(id,updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
