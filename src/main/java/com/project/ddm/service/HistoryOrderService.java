package com.project.ddm.service;

import com.project.ddm.exceptions.HistoryOrderException;
import com.project.ddm.model.Order;
import com.project.ddm.model.User;
import com.project.ddm.repository.OrderRepository;
import com.project.ddm.repository.UserAccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryOrderService {
    private UserAccountInfoRepository userAccountInfoRepository;
    private OrderRepository orderRepository;

    @Autowired
    public HistoryOrderService(UserAccountInfoRepository userAccountInfoRepository, OrderRepository orderRepository) {
        this.userAccountInfoRepository = userAccountInfoRepository;
        this.orderRepository = orderRepository;
    }

    public List<Order> findByUser(String username) throws HistoryOrderException{
        User user =  userAccountInfoRepository.findByUserId(username);
        return user.getOrders();
    }

    public Order findByOrderId(Long orderid){
        return orderRepository.findByOrderId(orderid);
    }
}
