package template.Application.controller.Data;

import java.sql.Date;

public class Review_Data {

	private int reviewid;
	private String content;
	private int star_score;
	private Date reviewdate;
	private int reservationid;
	private int moviesid;
	
	
	
	
	@Override
	public String toString() {
		return "Review_Data [reviewid=" + reviewid + ", content=" + content + ", star_score=" + star_score
				+ ", reviewdate=" + reviewdate + ", reservationid=" + reservationid + ", moviesid=" + moviesid + "]";
	}

	
	


	public Review_Data(String content) {
		super();
		this.content = content;
	}





	public Review_Data(String content, int moviesid) {
		super();
		this.content = content;
		this.moviesid = moviesid;
	}




	public Review_Data(int reviewid, String content, int star_score, Date reviewdate, int reservationid) {
		super();
		this.reviewid = reviewid;
		this.content = content;
		this.star_score = star_score;
		this.reviewdate = reviewdate;
		this.reservationid = reservationid;
	}




	public Review_Data(int reviewid, String content, int star_score, Date reviewdate, int reservationid, int moviesid) {
		super();
		this.reviewid = reviewid;
		this.content = content;
		this.star_score = star_score;
		this.reviewdate = reviewdate;
		this.reservationid = reservationid;
		this.moviesid = moviesid;
	}




	public int getReviewid() {
		return reviewid;
	}




	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public int getStar_score() {
		return star_score;
	}




	public void setStar_score(int star_score) {
		this.star_score = star_score;
	}




	public Date getReviewdate() {
		return reviewdate;
	}




	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}




	public int getReservationid() {
		return reservationid;
	}




	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}




	public int getMoviesid() {
		return moviesid;
	}




	public void setMoviesid(int moviesid) {
		this.moviesid = moviesid;
	}
	
	
	
	
}
