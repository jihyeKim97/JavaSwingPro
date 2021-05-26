package template.Application.view;

import java.sql.Date;

public class Movie {

<<<<<<< HEAD
	private int moviesid;
	private String title;
	private String genre;
	private String directer;
	private int agegroup;
	private String story;
	private int averageScore;
	private String gee;
	private Date opendate;
	private String production;
	private String imagefilename;
	private String scheduledate;
	private String runningtime;
	
	public Movie() {}
	
	
	
	public Movie(int moviesid, String title, String imagefilename, String scheduledate) {
=======
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
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.imagefilename = imagefilename;
		this.scheduledate = scheduledate;
	}

<<<<<<< HEAD



	public Movie(int moviesid, String title, String genre, String directer, int agegroup, String story,
			int averageScore, String gee, Date opendate, String production, String imagefilename, String scheduledate,
			String runningtime) {
=======
	public Movie(int moviesId, String title, String imageFileName, String scheduleDate) {
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
		super();
		this.moviesid = moviesid;
		this.title = title;
		this.genre = genre;
		this.directer = directer;
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

<<<<<<< HEAD


	@Override
	public String toString() {
		return "Movie [moviesid=" + moviesid + ", title=" + title + ", genre=" + genre + ", directer=" + directer
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



=======
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

>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getTitle() {
		return title;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setTitle(String title) {
		this.title = title;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getGenre() {
		return genre;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setGenre(String genre) {
		this.genre = genre;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getDirecter() {
		return directer;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setDirecter(String directer) {
		this.directer = directer;
	}

<<<<<<< HEAD


	public int getAgegroup() {
		return agegroup;
	}



	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}



=======
	public int getAgeGroup() {
		return AgeGroup;
	}

	public void setAgeGroup(int ageGroup) {
		AgeGroup = ageGroup;
	}

>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getStory() {
		return story;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setStory(String story) {
		this.story = story;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public int getAverageScore() {
		return averageScore;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getGee() {
		return gee;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setGee(String gee) {
		this.gee = gee;
	}

<<<<<<< HEAD


	public Date getOpendate() {
		return opendate;
	}



	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}



=======
	public Date getOpenDate() {
		return OpenDate;
	}

	public void setOpenDate(Date openDate) {
		OpenDate = openDate;
	}

>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public String getProduction() {
		return production;
	}

<<<<<<< HEAD


=======
>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
	public void setProduction(String production) {
		this.production = production;
	}

<<<<<<< HEAD


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
	
	
	
=======
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

>>>>>>> 79c08fe064a70d722c9564af6a5db1dc420d1646
}
	