package com.aistone.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aistone.springcloud.entites.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {
			
			@Override
			public Dept findById(long id) {
				
				return new Dept().setDeptno(id)
						.setDname("该ID"+id+"没有对应信息,comsummer提供的降级信息，此刻服务Provider已关闭")
						.setDname("no database in Mysql");
			}
			
			@Override
			public List<Dept> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean addDept(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
