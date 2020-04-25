package com.example.yangle.controller;

import com.example.yangle.service.IOrderService;
import com.example.yangle.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {

  @Autowired
  IOrderService service;

  /**.
   * 
   * @param aid not null
   * @param cids not null
   * @param session not null
   * @return
   */
  @PostMapping("create")
  public JsonResult<Void> createOrder(Integer aid, Integer[] cids, HttpSession session) {
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);
    service.createOrder(aid, cids, uid, username);
    return new JsonResult<>(SUCCESS);
  }

}
