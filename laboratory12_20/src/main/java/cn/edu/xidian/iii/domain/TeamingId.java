package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

/**
 * TeamingId generated by hbm2java
 */
public class TeamingId implements java.io.Serializable {

	private Integer userId;
	private Integer teamId;

	public TeamingId() {
	}

	public TeamingId(Integer userId, Integer teamId) {
		this.userId = userId;
		this.teamId = teamId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeamingId))
			return false;
		TeamingId castOther = (TeamingId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getTeamId() == castOther.getTeamId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getTeamId();
		return result;
	}

}
