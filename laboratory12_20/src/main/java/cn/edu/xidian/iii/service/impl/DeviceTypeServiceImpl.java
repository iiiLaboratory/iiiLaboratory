package cn.edu.xidian.iii.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.DeviceTypeDao;
import cn.edu.xidian.iii.domain.Devicetype;
import cn.edu.xidian.iii.service.DeviceTypeService;

public class DeviceTypeServiceImpl implements DeviceTypeService{
	
	@Autowired
	private DeviceTypeDao deviceTypeDao;

	
	public boolean register(Devicetype deviceType) {
		deviceTypeDao.save(deviceType);
		return true;
	}


	public boolean existenceDeviceType(Devicetype devicetype) {
		
		Devicetype example=new Devicetype();
		List<Devicetype> list=deviceTypeDao.findByExample(example);
		if (list.size()==0) {
			return false;
		}else {
			return true;
		}
		
	}


}
