package template.Application.view;

import java.sql.Date;

public class Movie {

	private int MoviessId;
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
	
	
	
	
	public Movie(int moviessId, String title, int averageScore) {
		super();
		MoviessId = moviessId;
		Title = title;
		AverageScore = averageScore;
	}

	


	public Movie(int moviessId, String title, String genre, String directer, int ageGroup, String story,
			int averageScore, String gee, Date openDate, String production, String imageFileName, String scheduleDate,
			String runningTime) {
		super();
		MoviessId = moviessId;
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
	
	
}
