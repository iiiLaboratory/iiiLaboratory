package cn.edu.xidian.iii.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.Devicetype;
import cn.edu.xidian.iii.service.DeviceTypeService;


@Controller
public class DeviceTypeRegisterController {
	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	@RequestMapping(value = "/type-register.do", method = RequestMethod.POST)
	public ModelAndView userResister(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("devicetype_register");
		
		String device_type=request.getParameter("device_type");
		String total_string=request.getParameter("total");
		String inventory_string=request.getParameter("inventory");
		
		int total=Integer.parseInt(total_string);
		int inventory=Integer.parseInt(inventory_string);
		
		Devicetype deviceType=new Devicetype(device_type,total,inventory);
		
		deviceTypeService.register(deviceType);
	
		return mav;
	}
	
	@RequestMapping(value = "/type-register.do", method = RequestMethod.GET)
	public ModelAndView userResisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("devicetype_register");
		
		
		return mav;
	}
	

}
