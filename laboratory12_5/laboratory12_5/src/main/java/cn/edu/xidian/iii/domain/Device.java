package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Device generated by hbm2java
 */
public class Device implements java.io.Serializable {

	private Integer deviceId;
	private Devicetype devicetype;
	private String deviceName;
	private String barcode;
	private Date registerTime;
	private String status;
	private String detail;
	private Integer count;
	private Integer totalTime;
	private Set<Note> notes = new HashSet<Note>(0);

	public Device() {
	}

	public Device(Devicetype devicetype, String deviceName, String barcode,
			String status) {
		this.devicetype = devicetype;
		this.deviceName = deviceName;
		this.barcode = barcode;
		this.status = status;
	}
	
	public Device(Devicetype devicetype, String deviceName, String barcode,
			 String status, String detail, Integer count,
			Integer totalTime) {
		this.devicetype = devicetype;
		this.deviceName = deviceName;
		this.barcode = barcode;
		this.status = status;
		this.detail = detail;
		this.count = count;
		this.totalTime = totalTime;
	}


	public Device(Devicetype devicetype, String deviceName, String barcode,
			Date registerTime, String status, String detail, Integer count,
			Integer totalTime, Set<Note> notes) {
		this.devicetype = devicetype;
		this.deviceName = deviceName;
		this.barcode = barcode;
		this.registerTime = registerTime;
		this.status = status;
		this.detail = detail;
		this.count = count;
		this.totalTime = totalTime;
		this.notes = notes;
	}

	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Devicetype getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(Devicetype devicetype) {
		this.devicetype = devicetype;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Set<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

}