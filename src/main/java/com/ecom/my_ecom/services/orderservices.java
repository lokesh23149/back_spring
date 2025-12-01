package com.ecom.my_ecom.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ecom.my_ecom.entities.orderitems;
import com.ecom.my_ecom.entities.orders;
import com.ecom.my_ecom.entities.products;
import com.ecom.my_ecom.productrepository.orderrepo;
import com.ecom.my_ecom.productrepository.productrepo;
import com.ecom.my_ecom.reviewsdao.ordercreateddto;
import com.ecom.my_ecom.reviewsdao.orderdao;
import com.ecom.my_ecom.reviewsdao.requestorder;



@Service
public class orderservices {

	@Autowired
	private productrepo prorepo;
	
	@Autowired
	private orderrepo ordrepo;

	public ordercreateddto createorder(requestorder requestorder) {
		if(requestorder.getOrderdao()==null||requestorder.getOrderdao().isEmpty()) {
			 throw	new RuntimeException("order is empty");
		}
		orders order = new orders();
		order.setStatus("pending"); 
		double totalitemamount=0;
		for (orderdao dao : requestorder.getOrderdao()) {
		    
		    orderitems item = new orderitems();

		    item.setName(dao.getName());
		    item.setImage(dao.getImage());
		    item.setPrice(dao.getPrice());
		    item.setQuantity(dao.getQuantity());

		    
		    
		    products product = prorepo.findById(dao.getProductid())
		    	    .orElseThrow(() -> new RuntimeException("product id not found"));

		    item.setProduct(product);
		   

		    totalitemamount += dao.getPrice() * dao.getQuantity();

		    order.getOrderitems().add(item);
		}

		
		
		
		order.setOrderitemtotal(totalitemamount);
		double totalamount=0;
		double gst=10;
		totalamount=totalitemamount+gst;
		order.setTotal(totalamount);
		order.setGst(gst);
		String refid=UUID.randomUUID().toString();
		order.setreferenceId(refid);
		
		ordrepo.save(order);
		return new ordercreateddto(refid);

	}

	

	public  orders getorder(String referenceID) {
		
	 orders order= ordrepo.findByReferenceId(referenceID)
			 .orElseThrow(() -> new RuntimeException("product id not found"));
	 return ordrepo.save(order);
	
				
	}

}
