package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

/**
 * Coursedevice generated by hbm2java
 */
public class Coursedevice implements java.io.Serializable {

	private CoursedeviceId id;
	private Course course;
	private Devicetype devicetype;
	private String detail;

	public Coursedevice() {
	}

	public Coursedevice(CoursedeviceId id, Course course, Devicetype devicetype) {
		this.id = id;
		this.course = course;
		this.devicetype = devicetype;
	}

	public Coursedevice(CoursedeviceId id, Course course,
			Devicetype devicetype, String detail) {
		this.id = id;
		this.course = course;
		this.devicetype = devicetype;
		this.detail = detail;
	}

	public CoursedeviceId getId() {
		return this.id;
	}

	public void setId(CoursedeviceId id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Devicetype getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(Devicetype devicetype) {
		this.devicetype = devicetype;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}