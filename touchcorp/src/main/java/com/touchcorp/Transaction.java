package com.touchcorp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
	private String hashedCreditCard;
	
	private LocalDateTime trxDate;
	
	private BigDecimal trxAmount;
	
	public Transaction(String hashedCreditCard,LocalDateTime trxDate,BigDecimal trxAmount){
		this.hashedCreditCard = hashedCreditCard;
		this.trxDate = trxDate;
		this.trxAmount = trxAmount;
	}

	public String getHashedCreditCard() {
		return hashedCreditCard;
	}

	public LocalDateTime getTrxDate() {
		return trxDate;
	}

	public BigDecimal getTrxAmount() {
		return trxAmount;
	}
	
	public String toString(){
		return hashedCreditCard + ":" + trxDate + ":" + trxAmount;
	}
}
