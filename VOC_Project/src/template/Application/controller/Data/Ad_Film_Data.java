package template.Application.controller.Data;

import java.util.Date;

public class Ad_Film_Data {

	private int movies_id;
	private String title;
	private String genre;
	private String director;
	private String age_group;
	private String story;
	private String average_score;
	private String gee;
	private String open_date;
	private String production;
	private String image_file_name;
	private String schedule_date;
	private String schedule_time;
	private String running_time;
	
	
	
	
	public Ad_Film_Data() {	}

	



	public Ad_Film_Data(String title, String genre, String director, String age_group, String story, String average_score,
			String gee, String open_date, String production, String schedule_date,
			String image_file_name, String running_time) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.age_group = age_group;
		this.story = story;
		this.average_score = average_score;
		this.gee = gee;
		this.open_date = open_date;
		this.production = production;
		this.schedule_date = schedule_date;
		this.image_file_name = image_file_name;
		this.running_time = running_time;
	}





	public Ad_Film_Data(int movies_id, String title, String genre, String director, String age_group, String story,
			String average_score, String gee, String open_date, String production, String image_file_name,
			String schedule_date, String schedule_time, String running_time) {
		super();
		this.movies_id = movies_id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.age_group = age_group;
		this.story = story;
		this.average_score = average_score;
		this.gee = gee;
		this.open_date = open_date;
		this.production = production;
		this.image_file_name = image_file_name;
		this.schedule_date = schedule_date;
		this.schedule_time = schedule_time;
		this.running_time = running_time;
	}





	public int getMovies_id() {
		return movies_id;
	}





	public void setMovies_id(int movies_id) {
		this.movies_id = movies_id;
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





	public String getAge_group() {
		return age_group;
	}





	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}





	public String getStory() {
		return story;
	}





	public void setStory(String story) {
		this.story = story;
	}





	public String getAverage_score() {
		return average_score;
	}





	public void setAverage_score(String average_score) {
		this.average_score = average_score;
	}





	public String getGee() {
		return gee;
	}





	public void setGee(String gee) {
		this.gee = gee;
	}





	public String getOpen_date() {
		return open_date;
	}





	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}





	public String getProduction() {
		return production;
	}





	public void setProduction(String production) {
		this.production = production;
	}





	public String getImage_file_name() {
		return image_file_name;
	}





	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}





	public String getSchedule_date() {
		return schedule_date;
	}





	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}





	public String getSchedule_time() {
		return schedule_time;
	}





	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}





	public String getRunning_time() {
		return running_time;
	}





	public void setRunning_time(String running_time) {
		this.running_time = running_time;
	}





	@Override
	public String toString() {
		return "Ad_Film_Data [movies_id=" + movies_id + ", title=" + title + ", genre=" + genre + ", director="
				+ director + ", age_group=" + age_group + ", story=" + story + ", average_score=" + average_score
				+ ", gee=" + gee + ", open_date=" + open_date + ", production=" + production + ", image_file_name="
				+ image_file_name + ", schedule_date=" + schedule_date + ", schedule_time=" + schedule_time
				+ ", running_time=" + running_time + "]";
	}
	
	
	
}
