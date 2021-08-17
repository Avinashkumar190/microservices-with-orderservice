package com.lara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.entity.Order;
import com.lara.entity.common.Payment;
import com.lara.entity.common.TransactionRequest;
import com.lara.entity.common.TransactionResponse;
import com.lara.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	/*
	 * @PostMapping("/bookorder") public Order bookOrder(@RequestBody Order order) {
	 * return service.saveOrder(order); //do a rest call to payment and pass the
	 * orderid }
	 */

	/*
	 * @PostMapping("/bookorder") public Order bookOrder(@RequestBody
	 * TransactionRequest request) { Order order = request.getOrder(); Payment
	 * payment = request.getPayment(); payment.setOrderId(order.getId());
	 * payment.setAmount(order.getPrice()); return service.saveOrder(order); //do a
	 * rest call to payment and pass the orderid }
	 */
	@PostMapping("/bookorder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

		return service.saveOrder(request);
	}

}
