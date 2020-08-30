package com.leyou.item.service;

import com.leyou.common.model.PageResult;
import com.leyou.item.model.Brand;

public interface BrandService {
    PageResult<Brand> findBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
}
