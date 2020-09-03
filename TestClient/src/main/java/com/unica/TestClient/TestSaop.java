package com.unica.TestClient;

import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.unica.entapp.model.GcdList;
import com.unica.entapp.model.NumberPair;
import com.unica.entapp.web.soap.OutputService;

public class TestSaop {
	
	public static void main(String args[]){
		try{
			URL url = new URL("http://localhost:8081/web/gcd?wsdl");
		    QName qname = new QName("http://soap.web.entapp.unica.com/", "OutputWebServiceService");
		 
		    Service service = Service.create(url, qname);
		 
		    OutputService outputService = service.getPort(OutputService.class);
		 
		    //System.out.println(outputService.gcd());	

		    System.out.println(outputService.gcdSum());
		    
		    System.out.println("List of GCDs:");
		    
		    GcdList lst = outputService.gcdList();
		    if(lst!=null){
		    	Iterator<Integer> itr = lst.getGcds().iterator();
		    	while(itr.hasNext()){
		    		Integer gcd = (Integer)itr.next();
		    		System.out.println(gcd);
		    	}
		    }
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	
		
	}

}
