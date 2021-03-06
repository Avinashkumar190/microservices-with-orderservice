package com.lara.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
	
	private int paymentId;
	private String paymentStaus;
	private String transactionId;
	private int orderId;
	private double amount;

}
