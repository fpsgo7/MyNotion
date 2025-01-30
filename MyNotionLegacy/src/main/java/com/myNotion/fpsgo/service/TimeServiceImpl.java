package com.myNotion.fpsgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myNotion.fpsgo.mapper.TimeMapper;

@Service
public class TimeServiceImpl implements TimeService{
	@Autowired
	TimeMapper mapper;
	
	@Override
	public String getTime() {
		return mapper.getTime();
	}
}
