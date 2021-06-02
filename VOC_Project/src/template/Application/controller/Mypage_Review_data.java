package template.Application.controller;

import java.util.Date;

public class Mypage_Review_data {
	Mypage_Reservation_data Mypage_reDT;
	int reviewID;
	String content;
	int star_score;
	Date reviewDate;
	int reservationID;
	int moviesID;
//	int reservationID = Mypage_reDT.getReservation_id();
//	int moviesID = Mypage_reDT.getMovie_id();

	@Override
	public String toString() {
		return "Mypage_Review_data [reviewID=" + reviewID + ", content=" + content + ", star_score=" + star_score
				+ ", reviewDate=" + reviewDate + ", reservationID=" + reservationID + ", moviesID=" + moviesID + "]";
	}

	public Mypage_Review_data(String content, int star_score) {
	super();
	this.content = content;
	this.star_score = star_score;
}

	public Mypage_Review_data(String content, int star_score, int reservationID, int moviesID) {
		super();
		this.content = content;
		this.star_score = star_score;
		this.reservationID = reservationID;
		this.moviesID = moviesID;
	}

	public Mypage_Review_data(int reviewID, String content, int star_score, Date reviewDate, int reservationID,
			int moviesID) {
		super();
		this.reviewID = reviewID;
		this.content = content;
		this.star_score = star_score;
		this.reviewDate = reviewDate;
		this.reservationID = reservationID;
		this.moviesID = moviesID;
	}

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
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

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getMoviesID() {
		return moviesID;
	}

	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}

}
