package com.ccarrot.employeeadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccarrot.employeeadmin.model.Area;
import com.ccarrot.employeeadmin.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaRepository areaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Area> getAll() {
		return areaRepository.findAll();
	}

}
