package cn.edu.xidian.iii.service.impl;



import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.DeviceTypeDao;
import cn.edu.xidian.iii.domain.Devicetype;
import cn.edu.xidian.iii.service.DeviceTypeService;

public class DeviceTypeServiceImpl implements DeviceTypeService{
	
	@Autowired
	private DeviceTypeDao deviceTypeDao;

	
	public boolean register(Devicetype deviceType) {
		// TODO Auto-generated method stub
		deviceTypeDao.save(deviceType);
		return true;
	}


}
