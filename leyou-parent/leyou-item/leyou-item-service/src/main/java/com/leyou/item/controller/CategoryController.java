package com.leyou.item.controller;

import com.leyou.item.model.Category;
import com.leyou.item.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    private CategoryServiceImpl categoryService;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 查询种类列表.
     * @param id 母种类id
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Category>> findCategoryById(@RequestParam(name = "pid",defaultValue = "0") Long id) {
        if (id < 0 || id == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Category> list = categoryService.findCategoryById(id);
        if (CollectionUtils.isEmpty(list)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
}
