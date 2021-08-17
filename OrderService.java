package com.lara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lara.entity.Order;
import com.lara.entity.common.Payment;
import com.lara.entity.common.TransactionRequest;
import com.lara.entity.common.TransactionResponse;
import com.lara.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate template;

	/*
	 * public Order saveOrder(Order order) { return orderRepository.save(order); }
	 */

	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		Order order = request.getOrder(); 
		Payment payment = request.getPayment(); 
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//rest call
		//do a rest call to payment and pass the orderid //PAYMENT-SERVICE
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/dopayment", payment, Payment.class);
		//Payment paymentResponse = template.postForObject("http://localhost:9191/payment/dopayment", payment, Payment.class);
		response = paymentResponse.getPaymentStaus()
				.equals("success") ? "payment processing successfuly and order placed" : "this is a failure in payment api,order added to cart";
		orderRepository.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),
				paymentResponse.getTransactionId(),response);
	}

}
