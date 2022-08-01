package com.chainsys.socialmedia.pojo;

import java.io.File;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	private int postid;
	private int userid;
	private File posttype;
	private String medialocation;
	private String visibility;
	private String dates;
	private String times;
	private int likecount;
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public File getPosttype() {
		return posttype;
	}
	public void setPosttype(File posttype) {
		this.posttype = posttype;
	}
	public String getMedialocation() {
		return medialocation;
	}
	public void setMedialocation(String medialocation) {
		this.medialocation = medialocation;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public String getDates() {
		return dates;
	}
	public void setDates() {
		Calendar vCalendar = Calendar.getInstance();
		String dates =  vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR);
		this.dates = dates;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes() {
		Calendar vCalendar = Calendar.getInstance();
		String times = vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.times = times;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	
	
}
