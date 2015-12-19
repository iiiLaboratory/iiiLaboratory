package cn.edu.xidian.iii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.Device;
import cn.edu.xidian.iii.domain.Devicetype;
import cn.edu.xidian.iii.service.DeviceService;

@Controller
public class DeviceRegisterController {
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value="/device-register.do",method=RequestMethod.POST)
	public ModelAndView deviceResister(HttpServletRequest request, HttpSession session) {
		ModelAndView mav=new ModelAndView("device_register");
		
		
		String deviceName=request.getParameter("device_name");
		String barcode=request.getParameter("barcode");
		String deviceType=request.getParameter("device_type");
		String count_String =request.getParameter("count");
		String total_time_String=request.getParameter("total_time");
		String detail=request.getParameter("detail");
		
		int count=Integer.parseInt(count_String);
		int total_time=Integer.parseInt(total_time_String);
		
		
		Devicetype dev=new Devicetype(deviceType);
		
		
		Device device=new Device(dev,deviceName,barcode,"student",detail,count,total_time);
		
		deviceService.deviceSave(device);
		
		return mav;
	
	}
	
	@RequestMapping(value="/device-register.do",method=RequestMethod.GET)
	public ModelAndView deviceResisterGET(HttpServletRequest request, HttpSession session) {
		ModelAndView mav=new ModelAndView("device_register");
		return mav;
	}

}
