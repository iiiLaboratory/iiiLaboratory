package cn.edu.xidian.iii.controller;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import cn.edu.xidian.iii.util.HandleExcel;
import cn.edu.xidian.iii.service.DeviceTypeService;

@Controller
public class DeviceRegisterController {
	@Autowired
	private DeviceService deviceService;
<<<<<<< HEAD:laboratory12_5/laboratory12_5/src/main/java/cn/edu/xidian/iii/controller/DeviceRegisterController.java
	@Autowired
	private DeviceTypeService deviceTypeService;

	@RequestMapping(value = "/DoExcel.do", method = RequestMethod.POST)
	public ModelAndView deviceResister(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("excelupload");
        System.out.println("1111");
		InputStream inputStream = HandleExcel.getExcelInputStream(request);
		List<String[]> rowcontents = HandleExcel.readExcel(inputStream);
		// *****************
		String deviceName;
		String barcode;
		String deviceType = null;
		String count_String;
		//String total_time_String;
		String detail;
		String[] strings = null;
		Pattern pattern=Pattern.compile("[0-9]*");

		for (Iterator<String[]> it=rowcontents.iterator();it.hasNext();) {
			System.out.println("222222");
			
			strings = it.next();
			if (!strings[8].matches("[0-9]+")) {
				continue;
			}
			deviceType = strings[0];
			deviceName = strings[1];
			count_String = strings[2];
			detail = strings[3] + strings[4] + strings[5] + strings[6] + strings[7];
			//total_time_String = strings[7];
			barcode = strings[8];

			int count = Integer.parseInt(count_String);
			//int total_time = Integer.parseInt(total_time_String);
			//***条形码格式判断***
			Matcher isNum=pattern.matcher(barcode);
			if (!isNum.matches()) {
				System.err.println("barcode style Error!!!");
			} 
			//***条形码格式判断结束***
			//***组号格式判断***
			Matcher groupisNum=pattern.matcher(count_String);
			if (!groupisNum.matches()) {
				System.err.println("Group ID style Error!!!");
			} 

			Devicetype dev = new Devicetype(deviceType);
			if (!deviceTypeService.existenceDeviceType(dev)) {
				
				deviceTypeService.register(dev);
			}
			Device device = new Device(dev, deviceName, barcode, "student", detail, count);

			deviceService.deviceSave(device);

		}

=======
	
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
		
>>>>>>> 2eb59af1176a1124fdc0ca719271f913582e8445:laboratory12_20/src/main/java/cn/edu/xidian/iii/controller/DeviceRegisterController.java
		return mav;

	}

	@RequestMapping(value = "/DoExcel.do", method = RequestMethod.GET)
	public ModelAndView deviceResisterGET(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("excelupload");
		return mav;
	}

}
