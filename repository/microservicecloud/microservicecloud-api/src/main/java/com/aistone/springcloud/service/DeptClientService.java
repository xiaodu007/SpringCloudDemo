package com.aistone.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aistone.springcloud.entites.Dept;

@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean addDept(Dept dept);
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept findById(@PathVariable("id") long id);
	
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> findAll();
}
