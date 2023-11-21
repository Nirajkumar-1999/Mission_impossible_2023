package com.example.washermicroservice.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.washermicroservice.model.Order;
import com.example.washermicroservice.model.WashPacks;
import com.example.washermicroservice.model.Washer;
import com.example.washermicroservice.repository.WasherRepo;
import com.example.washermicroservice.service.WasherService;







@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/washer")
@Validated
public class WasherController {
	
	@Autowired
	WasherService washerService;
	
	@Autowired
	WasherRepo washerRepo;
	
	
	
	
	
	 //To see the Unassigned orders
    @GetMapping("/findUnassigned")
    public List<Order> getUnassignedOrders(){
        return washerService.getUnassignedOrders();
    }
    
  //The status of the order can be either pending or completed
    @PutMapping("/updateStatus")
    public Order updateStatusoftheOrder(@RequestBody Order orderDetails){
        return washerService.updateStatus(orderDetails);
    }
    
    
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public Order assignSelf(@RequestBody Order orderDetails){
        return washerService.assignSelf(orderDetails);
    }
    
    
    //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return washerService.getAllWP();
    }
    
    @PostMapping("/addWashers")
    public Washer addwasher(@RequestBody Washer washer) {
    	return washerService.addWashers(washer);
    }
    
    @GetMapping("/allWashers")
    public List<Washer> getAllWashers(){
    	return washerService.findAllWasher();
    }

}
