package com.example.tutoriareto3.controller;

import com.example.tutoriareto3.entities.Category;
import com.example.tutoriareto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable("id") int id){ return categoryService.getCategory(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
         return categoryService.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }


}
