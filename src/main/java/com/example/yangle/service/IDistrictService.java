package com.example.yangle.service;

import com.example.yangle.entity.District;

import java.util.List;

/**
 * 省市区信息的业务层接口
 */
public interface IDistrictService {

  /**
   * 根据父级编号查询所有子级地区信息
   * 
   * @param parent 父级编号
   * @return 所有子级地区信息
   */
  List<District> listByParent(String parent);

  /**
   * 根据地区编号查询地区信息
   * 
   * @param code 地区编号
   * @return 地区信息
   */
  District getByCode(String code);
}
