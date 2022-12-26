package com.webapp.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.ECDao;
import com.webapp.demo.ecommerce.E_Commerce;

@RestController
public class ECController {

	@Autowired
	ECDao dao;
	@RequestMapping("/saveProduct")
	@ResponseBody
	public void saveProduct(@RequestParam String id, String name,String desc,String qnt,String price,String type,E_Commerce obj) {
	
	obj.setProductId(id);
	obj.setProductName(name);
	obj.setDescription(desc);
	obj.setQuantity(qnt);
	obj.setPrice(price);
	obj.setType(type);
	dao.save(obj);
	System.out.print("added");
		
	}
	
	@RequestMapping("/getByType")
	@ResponseBody
	public List<E_Commerce> getByType(@RequestParam String type) {
		
		return dao.byType(type);
		
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteProduct(@RequestParam String id) {
		
		System.out.println("product deleted");
		dao.delete(id);
		
	
}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<E_Commerce> getAll() {
		
		return dao.findAll();
	}
	
	@RequestMapping("/getById")
	@ResponseBody
	public List<E_Commerce> getById(@RequestParam String id) {
		System.out.println("ecommerce by id");
		return dao.byId(id);
		
	}
	
}