package com.example.yangle.controller;

import com.example.yangle.entity.Product;
import com.example.yangle.service.IProductService;
import com.example.yangle.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

  @Autowired
  IProductService service;

  /**.
   * 
   * @return
   */
  @GetMapping("hot")
  public JsonResult<List<Product>> getHotList() {
    // 查询
    List<Product> data = service.getHotList();
    // 返回
    return new JsonResult<List<Product>>(SUCCESS, data);
  }

  @GetMapping("{id}/get")
  public JsonResult<Product> getById(@PathVariable("id") Integer id) {
    Product product = service.getById(id);
    return new JsonResult<Product>(SUCCESS, product);
  }

}
