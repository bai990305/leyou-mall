package com.leyou.item.service;


import com.leyou.item.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findCategoryById(Long id);
}
