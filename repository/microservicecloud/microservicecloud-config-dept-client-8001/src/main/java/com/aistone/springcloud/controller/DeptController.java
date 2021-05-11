package com.aistone.springcloud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistone.springcloud.entites.Dept;
import com.aistone.springcloud.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.findById(id);
	}
	
	@RequestMapping(value="/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return deptService.findAll();
	}
	@RequestMapping(value = "/dept/discovery")
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);
		
		List<ServiceInstance> serList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance element : serList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" 
					+ element.getPort() + "\t" + element.getUri());
		}
		return this.client;
	}
}
