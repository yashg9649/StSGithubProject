package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.LoadDao;
import com.springrest.springrest.entities.Load;
@Service
public class loadServiceimpl implements loadService {

//	List<Load> list;
	@Autowired
	private LoadDao loadDao;
	public loadServiceimpl() {
		
	}

	@Override
	public List<Load> getLoads() {
		return loadDao.findAll();
	}
	
	public Load getLoad(long loadId) {
		return loadDao.getOne(loadId);
	}
	
	public Load addLoad(Load load) {
		loadDao.save(load);
		return load;
	}

	public Load updateLoad(Load load){
		loadDao.save(load);
		return load;
	}
	
	public void deleteLoad(long parseLong) {
		Load entity = loadDao.getOne(parseLong);
		loadDao.delete(entity);
	}
	
	

}
