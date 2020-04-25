package com.example.yangle.controller;

import com.example.yangle.entity.CartVO;
import com.example.yangle.service.ICartService;
import com.example.yangle.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("carts")
public class CartController extends BaseController {

  @Autowired
  ICartService service;

  /**.
   * 
   * @param num not null
   * @param pid not null
   * @param session not null
   * @return
   */
  @RequestMapping("create_cart")
  public JsonResult<Void> createCart(Integer num, Integer pid, HttpSession session) {
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);

    service.createCart(num, uid, pid, username);
    return new JsonResult<Void>(SUCCESS);
  }

  /**.
   * 
   * @param cid not null
   * @param num not null
   * @param session not null
   * @return
   */
  @RequestMapping("add_num")
  public JsonResult<Void> addNum(Integer cid, Integer num, HttpSession session) {
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);

    service.addNum(cid, num, uid, username);
    return new JsonResult<Void>(SUCCESS);
  }
  
  // /carts/cid/del
  /**.
   * 
   * @param cid not null
   * @param session not null
   * @return
   */
  @RequestMapping("{cid}/del")
  public JsonResult<Void> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
    Integer uid = getUidFromSession(session);

    service.removeCart(cid, uid);
    return new JsonResult<Void>(SUCCESS);
  }

  /**.
   * 
   * @param cid not null
   * @param num not null
   * @param session not null
   * @return
   */
  @RequestMapping("reduce_num")
  public JsonResult<Void> reduceNum(Integer cid, Integer num, HttpSession session) {
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);

    service.reduceNum(cid, num, uid, username);
    return new JsonResult<Void>(SUCCESS);
  }



  /**.
   * 
   * @param session not null
   * @return
   */
  @GetMapping("/")
  public JsonResult<List<CartVO>> getCartList(HttpSession session) {
    Integer uid = getUidFromSession(session);

    List<CartVO> list = service.getCartList(uid);

    return new JsonResult<List<CartVO>>(SUCCESS, list);
  }

  /**.
   * 
   * @param cids not null
   * @param session not null
   * @return
   */
  @GetMapping("get_by_cids")
  public JsonResult<List<CartVO>> getByCids(Integer[] cids, HttpSession session) {
    Integer uid = getUidFromSession(session);

    List<CartVO> data = service.getByCids(cids, uid);
    return new JsonResult<>(SUCCESS, data);
  }

}
