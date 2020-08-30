package com.leyou.item.controller;

import com.leyou.common.model.PageResult;
import com.leyou.item.model.Brand;
import com.leyou.item.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController {
    private BrandServiceImpl brandService;
    @Autowired
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> findBrandByPage(
            @RequestParam(name = "key",required = false) String key,
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "rows",defaultValue = "5") int rows,
            @RequestParam(name = "sortBy",required = false) String sortBy,
            @RequestParam(name = "desc", required = false) Boolean desc
    ) {
        PageResult<Brand> pageResult = brandService.findBrandsByPage(key, page, rows, sortBy, desc);
        return ResponseEntity.ok(pageResult);
    }
}
