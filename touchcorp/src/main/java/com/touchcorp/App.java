package com.touchcorp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App 
{	
    public static Set<String> detectFraudulentCards(List<Transaction> transactions, LocalDate runDate,BigDecimal threshold){
    	Set<String> fradulentCards = new HashSet<>();	
    	Map<String, BigDecimal> trxMap = new HashMap<>();
    	BigDecimal sumAmount = null;
    	for(Transaction transaction : transactions){
    		if(transaction.getTrxDate().toLocalDate().equals(runDate)){
    			sumAmount = trxMap.get(transaction.getHashedCreditCard());
    			if(sumAmount != null)
    				sumAmount = sumAmount.add(transaction.getTrxAmount());
   				else
   					sumAmount = transaction.getTrxAmount();
    			trxMap.put(transaction.getHashedCreditCard(), sumAmount);
				if(sumAmount.compareTo(threshold) == 1)
					fradulentCards.add(transaction.getHashedCreditCard());
    		}
    	}
    	return fradulentCards;
    } 
}
