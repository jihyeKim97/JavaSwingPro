package template.Application.view;

import java.sql.Date;

public class Movie {

	private int MoviesId;
	private String Title;
	private String Genre;
	private String Directer;
	private int AgeGroup;
	private String Story;
	private int AverageScore;
	private String Gee;
	private Date OpenDate;
	private String Production;
	private String ImageFileName;
	private String ScheduleDate;
	private String RunningTime;
	
	
	
	
	public Movie(int moviesId, String title, int averageScore) {
		super();
		MoviesId = moviesId;
		Title = title;
		AverageScore = averageScore;
	}

	
	

	public Movie(int moviesId, String title, String imageFileName, String scheduleDate) {
		super();
		MoviesId = moviesId;
		Title = title;
		ImageFileName = imageFileName;
		ScheduleDate = scheduleDate;
	}




	public Movie(int moviesId, String title, String genre, String directer, int ageGroup, String story,
			int averageScore, String gee, Date openDate, String production, String imageFileName, String scheduleDate,
			String runningTime) {
		super();
		MoviesId = moviesId;
		Title = title;
		Genre = genre;
		Directer = directer;
		AgeGroup = ageGroup;
		Story = story;
		AverageScore = averageScore;
		Gee = gee;
		OpenDate = openDate;
		Production = production;
		ImageFileName = imageFileName;
		ScheduleDate = scheduleDate;
		RunningTime = runningTime;
	}




	public int getMoviesId() {
		return MoviesId;
	}




	public void setMoviesId(int moviessId) {
		MoviesId = moviessId;
	}




	public String getTitle() {
		return Title;
	}




	public void setTitle(String title) {
		Title = title;
	}




	public String getGenre() {
		return Genre;
	}




	public void setGenre(String genre) {
		Genre = genre;
	}




	public String getDirecter() {
		return Directer;
	}




	public void setDirecter(String directer) {
		Directer = directer;
	}




	public int getAgeGroup() {
		return AgeGroup;
	}




	public void setAgeGroup(int ageGroup) {
		AgeGroup = ageGroup;
	}




	public String getStory() {
		return Story;
	}




	public void setStory(String story) {
		Story = story;
	}




	public int getAverageScore() {
		return AverageScore;
	}




	public void setAverageScore(int averageScore) {
		AverageScore = averageScore;
	}




	public String getGee() {
		return Gee;
	}




	public void setGee(String gee) {
		Gee = gee;
	}




	public Date getOpenDate() {
		return OpenDate;
	}




	public void setOpenDate(Date openDate) {
		OpenDate = openDate;
	}




	public String getProduction() {
		return Production;
	}




	public void setProduction(String production) {
		Production = production;
	}




	public String getImageFileName() {
		return ImageFileName;
	}




	public void setImageFileName(String imageFileName) {
		ImageFileName = imageFileName;
	}




	public String getScheduleDate() {
		return ScheduleDate;
	}




	public void setScheduleDate(String scheduleDate) {
		ScheduleDate = scheduleDate;
	}




	public String getRunningTime() {
		return RunningTime;
	}




	public void setRunningTime(String runningTime) {
		RunningTime = runningTime;
	}
	
	
}
