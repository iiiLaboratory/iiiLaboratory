package cn.edu.xidian.iii.domain;

// Generated 2015-11-12 11:21:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Teaming generated by hbm2java
 */
public class Teaming implements java.io.Serializable {

	private TeamingId id;
	private User user;
	private Team team;
	private String status;
	private Date addTime;

	public Teaming() {
	}

	public Teaming(User user, Team team) {
		id=new TeamingId(user.getUserId(),team.getTeamId());
		//System.out.println("teaming"+user.getUserId()+team.getTeamId());
		this.user = user;
		this.team = team;
	}
	
	public Teaming(TeamingId id, User user, Team team) {
		this.id = id;
		this.user = user;
		this.team = team;
	}

	public Teaming(TeamingId id, User user, Team team, String status,
			Date addTime) {
		this.id = id;
		this.user = user;
		this.team = team;
		this.status = status;
		this.addTime = addTime;
	}

	public TeamingId getId() {
		return this.id;
	}

	public void setId(TeamingId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
