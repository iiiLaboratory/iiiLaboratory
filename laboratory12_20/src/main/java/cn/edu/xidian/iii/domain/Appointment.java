package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Appointment generated by hbm2java
 */
public class Appointment implements java.io.Serializable {

	private Integer appointId;
	private Team team;
	private Devicetype devicetype;
	private Date appointTime;
	private Date appBeginTime;
	private Date appEndTime;
	private String status;

	public Appointment() {
	}

	public Appointment(Team team, Devicetype devicetype, Date appBeginTime,
			Date appEndTime) {
		this.team = team;
		this.devicetype = devicetype;
		this.appBeginTime = appBeginTime;
		this.appEndTime = appEndTime;
	}

	public Appointment(Team team, Devicetype devicetype, Date appointTime,
			Date appBeginTime, Date appEndTime, String status) {
		this.team = team;
		this.devicetype = devicetype;
		this.appointTime = appointTime;
		this.appBeginTime = appBeginTime;
		this.appEndTime = appEndTime;
		this.status = status;
	}

	public Integer getAppointId() {
		return this.appointId;
	}

	public void setAppointId(Integer appointId) {
		this.appointId = appointId;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Devicetype getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(Devicetype devicetype) {
		this.devicetype = devicetype;
	}

	public Date getAppointTime() {
		return this.appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public Date getAppBeginTime() {
		return this.appBeginTime;
	}

	public void setAppBeginTime(Date appBeginTime) {
		this.appBeginTime = appBeginTime;
	}

	public Date getAppEndTime() {
		return this.appEndTime;
	}

	public void setAppEndTime(Date appEndTime) {
		this.appEndTime = appEndTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}