package cn.edu.xidian.iii.service;

import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Team;
import cn.edu.xidian.iii.domain.Teaming;
import cn.edu.xidian.iii.domain.User;

public interface TeamService {
   public User findUserByStuNum(String stunum);
   public  Course findCourseById(String courseid);
   public  boolean saveTeam(Team team);
   public  int findTeamid(Team team);
   public  boolean saveTeaming(Teaming teaming);
   public boolean  teamExist(Team team);
   public Team  findTeam(Team team);
   public boolean  teamingExist(Teaming teaming);
   public int findMaxTeamid(Course course);
}
