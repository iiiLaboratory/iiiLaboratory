package cn.edu.xidian.iii.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.DeviceDao;
import cn.edu.xidian.iii.domain.Device;
import cn.edu.xidian.iii.service.DeviceService;

public class DeviceServiceImpl implements DeviceService{
    
	@Autowired
	private DeviceDao deviceDao;
	public boolean deviceSave(Device device) {
		// TODO Auto-generated method stub
		device.setRegisterTime(new Date());
		deviceDao.save(device);
		return true;
	}

}
