package com.bim.in.controller;
import com.bim.in.entity.Category;

import com.bim.in.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Optional;
@RestController

@RequestMapping("/api")

public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired

    public CategoryController(CategoryRepository categoryRepository) {

        super();

        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/category/description/{catid}")

    public List<Category> findBycatid(@PathVariable int catid)

    {
        return categoryRepository.findBycatid(catid);

    }

    @PutMapping("/update/category/{CatID}")
    public ResponseEntity<Category> updateCategory(@PathVariable int catid, @RequestBody Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(catid);
        if (!optionalCategory.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Category existingCategory = optionalCategory.get();
        existingCategory.setCat_description(updatedCategory.getCat_description());
        Category updatedExistingCategory = categoryRepository.save(existingCategory);
        return ResponseEntity.ok(updatedExistingCategory);
    }
}
