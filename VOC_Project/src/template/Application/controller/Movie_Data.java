package template.Application.controller;

import java.util.Date;

public class Movie_Data {
	private static final int DEF_MOVIEID = 0;
	private static final String DEF_TITLE = "제목없음";
	private static final String DEF_GENRE = "장르없음";
	private static final String DEF_DIRECTOR = "감독없음";
	private static final int DEF_AGEGROUP = 0;
	private static final String DEF_story = "스토리없음";
	private static final int DEF_averageScore = 0;
	private static final String DEF_gee = "등장인물 없음";
	private static final Date DEF_opendate = (Date) new java.util.Date();
	private static final String DEF_production = "제작사 없음";
	private static final String DEF_imagefilename = "이미지 없음";
	private static final Date DEF_scheduledate = (Date) new java.util.Date();
	private static final int DEF_scheduletime = 1;
	private static final String DEF_runningtime = "이미지 없음";
	
	
	
	private int moviesid;
	private String title;
	private String genre;
	private String director;
	private int agegroup;
	private String story;
	private int averageScore;
	private String gee;
	private Date opendate;
	private String production;
	private String imagefilename;
	private Date scheduledate;
	private int scheduletime;
	private String runningtime;
	
	

	public Movie_Data() {
	}

	public int getMoviesid() {
		return moviesid;
	}

	public void setMoviesid(int moviesid) {
		this.moviesid = moviesid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	public String getGee() {
		return gee;
	}

	public void setGee(String gee) {
		this.gee = gee;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getImagefilename() {
		return imagefilename;
	}

	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}

	public Date getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

	public int getScheduletime() {
		return scheduletime;
	}

	public void setScheduletime(int scheduletime) {
		this.scheduletime = scheduletime;
	}

	public String getRunningtime() {
		return runningtime;
	}

	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}

	@Override
	public String toString() {
		return "Movie_Data [moviesid=" + moviesid + ", title=" + title + ", genre=" + genre + ", director=" + director
				+ ", agegroup=" + agegroup + ", story=" + story + ", averageScore=" + averageScore + ", gee=" + gee
				+ ", opendate=" + opendate + ", production=" + production + ", imagefilename=" + imagefilename
				+ ", scheduledate=" + scheduledate + ", scheduletime=" + scheduletime + ", runningtime=" + runningtime
				+ "]";
	}
	
	

	public Movie_Data(int moviesid, String imagefilename, Date scheduledate) {
		super();
		this.moviesid = moviesid;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
	}

	public Movie_Data(int moviesid, Date scheduledate) {
		super();
		this.moviesid = moviesid;
		this.scheduledate = scheduledate;
	}

	public Movie_Data(int moviesid, String title, String imagefilename, Date scheduledate, int scheduletime,
			String runningtime) {
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
		this.scheduletime = scheduletime;
		this.runningtime = runningtime;
	}

	public Movie_Data(int moviesid, String title, String genre, String director, int agegroup, String story,
			int averageScore, String gee, Date opendate, String production, String imagefilename, Date scheduledate,
			int scheduletime, String runningtime) {
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.agegroup = agegroup;
		this.story = story;
		this.averageScore = averageScore;
		this.gee = gee;
		this.opendate = opendate;
		this.production = production;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
		this.scheduletime = scheduletime;
		this.runningtime = runningtime;
	}

}