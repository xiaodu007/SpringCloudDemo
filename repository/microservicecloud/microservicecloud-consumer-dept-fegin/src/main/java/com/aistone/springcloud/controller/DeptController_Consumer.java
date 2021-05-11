package com.aistone.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aistone.springcloud.entites.Dept;
import com.aistone.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService clientService;
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.clientService.addDept(dept);
	}
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") long id) {
		return this.clientService.findById(id);
	}
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list (){
		return this.clientService.findAll();
	}
}
