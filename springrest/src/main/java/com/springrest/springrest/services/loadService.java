package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Load;

public interface loadService {
	public List<Load> getLoads();
	public Load getLoad(long loadId);
	public Load addLoad(Load load);
	public Load updateLoad(Load load);
	public void deleteLoad(long parseLong);
}
