package com.example.yangle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yangle.entity.District;
import com.example.yangle.mapper.DistrictMapper;
import com.example.yangle.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {

  @Autowired
  DistrictMapper mapper;

  public List<District> listByParent(String parent) {
    return findByParent(parent);
  }

  private List<District> findByParent(String parent) {
    return mapper.findByParent(parent);
  }

  public District getByCode(String code) {
    return findByCode(code);
  }

  private District findByCode(String code) {
    return mapper.findByCode(code);
  }

}
