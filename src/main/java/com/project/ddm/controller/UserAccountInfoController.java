package com.project.ddm.controller;

import com.project.ddm.model.Order;
import com.project.ddm.model.User;
import com.project.ddm.service.HistoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserAccountInfoController {
    private HistoryOrderService historyOrderService;

    @Autowired
    public UserAccountInfoController(HistoryOrderService historyOrderService) {
        this.historyOrderService = historyOrderService;
    }
  //  @GetMapping("/historyorders")
 /*   public String listOrders(String username) {
        return historyOrderService.findByUser(username);
    } */
    @GetMapping(value="/historyorders")
    public List<Order> historyOrders(@RequestParam(name = "userid") String userid) {
        return historyOrderService.findByUser(userid);
    }

    @GetMapping(value="/searchorder")
    public Order searchOrders(@RequestParam(name = "orderid") Long id) {
        return historyOrderService.findByOrderId(id);
    }
}
