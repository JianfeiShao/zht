package com.zht.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zht.mapper.EyMapper;
import com.zht.util.mybatis.M;

@Service("eyModel")
public class EyModel {
	
	@Autowired
	M m;
	
	public void add(String message){
		m.getMapper(EyMapper.class).add(message);
	}
}
