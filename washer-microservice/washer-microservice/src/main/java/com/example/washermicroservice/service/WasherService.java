package com.example.washermicroservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.washermicroservice.model.Order;
import com.example.washermicroservice.model.WashPacks;
import com.example.washermicroservice.model.Washer;
import com.example.washermicroservice.repository.WasherRepo;






@Service
public class WasherService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WasherRepo washerrepo;
	
	// This url is to access the admin microservice
	String url="https://admin-microservice/admin";
	
	// This url is to access the order-microservice
	String url1="https://order-microservice/order";
	
	
	// To add a Washer
	public Washer addWashers(Washer washers) {
		
		return washerrepo.save(washers);
	}
	
	
	//To find list of washers
	public List<Washer> findAllWasher(){
		
		return washerrepo.findAll();
	}
	
	//To see all the WashPacks
    public List<WashPacks> getAllWP(){
        WashPacks[] wp=restTemplate.getForObject(url1+"/findallWP",WashPacks[].class);
        return (Arrays.asList(wp));
    }
    
    //To see the Unassigned orders
    public List<Order> getUnassignedOrders(){
        Order[] unassignedList = restTemplate.getForObject(url+"/findUnassigned",Order[].class);
        return Arrays.asList(unassignedList);
    }
    
    //To update the status of the order by Washer
    public Order updateStatus(Order orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Order> updatedOrder = new HttpEntity<>(orderDetails,headers);
        Order od = restTemplate.exchange(url+"/updateStatus", HttpMethod.PUT,updatedOrder,Order.class).getBody();
        return od;
    }
    
  //To assign a washer to the order by washer
    public Order assignSelf(Order orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Order> assignedWasher = new HttpEntity<>(orderDetails,headers);
        Order od = restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,Order.class).getBody();
        return od;
    }

}
