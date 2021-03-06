package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

/**
 * ElectiveId generated by hbm2java
 */
public class ElectiveId implements java.io.Serializable {

	private Integer userId;
	private Integer courseId;

	public ElectiveId() {
	}

	public ElectiveId(Integer userId, Integer courseId) {
		this.userId = userId;
		this.courseId = courseId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ElectiveId))
			return false;
		ElectiveId castOther = (ElectiveId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getCourseId() == castOther.getCourseId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getCourseId();
		return result;
	}

}
