package com.touchcorp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	List<Transaction> transactions;
    
    public static junit.framework.Test suite() {
    	return new JUnit4TestAdapter(AppTest.class);
    }    
    
    @Before
    public void setUp() throws Exception {
    	transactions = new ArrayList<>();
		String line = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		 try (BufferedReader br = 
				 new BufferedReader(
						 new InputStreamReader(
								 getClass().getClassLoader().
								 getResourceAsStream("transactions.csv")))) {
			 while ((line = br.readLine()) != null) {
					String[] transaction = line.split(",");
					transactions.add(new Transaction(transaction[0], 
							LocalDateTime.parse(transaction[1], formatter),
							new BigDecimal(transaction[2]) ));
				}
		 }		
    }  
    
    @After
    public void tearDown() {
    	transactions.clear();
    }    

    /**
     * Rigourous Test :-)
     */
    @org.junit.Test
    public void testApp()
    {
    	Set<String> fradulentCards = App.detectFraudulentCards(transactions, LocalDate.of(2014, Month.APRIL, 29), new BigDecimal(10));
    	assertNotNull(fradulentCards);
    	assertEquals("a3dae5ed32e344ce4633caf876e60a70cd31a8f2", fradulentCards.stream().findFirst().get());
    }
}
