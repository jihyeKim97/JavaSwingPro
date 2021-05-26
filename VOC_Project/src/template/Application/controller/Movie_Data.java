package template.Application.controller;

import java.sql.Date;

public class Movie_Data {

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
	private String scheduledate;
	private String runningtime;
	
	public Movie_Data() {}
	
	
	

	public Movie_Data(int moviesid, String title, String genre, String imagefilename, String scheduledate,
			String runningtime) {
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.genre = genre;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
		this.runningtime = runningtime;
	}




	public Movie_Data(int moviesid, String title, String imagefilename, String scheduledate) {
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
	}




	public Movie_Data(int moviesid, String title, String genre, String director, int agegroup, String story,
			int averageScore, String gee, Date opendate, String production, String imagefilename, String scheduledate,
			String runningtime) {
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
		this.runningtime = runningtime;
	}




	@Override
	public String toString() {
		return "Movie_Data [moviesid=" + moviesid + ", title=" + title + ", genre=" + genre + ", director=" + director
				+ ", agegroup=" + agegroup + ", story=" + story + ", averageScore=" + averageScore + ", gee=" + gee
				+ ", opendate=" + opendate + ", production=" + production + ", imagefilename=" + imagefilename
				+ ", scheduledate=" + scheduledate + ", runningtime=" + runningtime + "]";
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




	public String getScheduledate() {
		return scheduledate;
	}




	public void setScheduledate(String scheduledate) {
		this.scheduledate = scheduledate;
	}




	public String getRunningtime() {
		return runningtime;
	}




	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}
	
	
	
}
