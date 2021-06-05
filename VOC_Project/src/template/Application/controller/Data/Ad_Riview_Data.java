package template.Application.controller.Data;

public class Ad_Riview_Data {

	String review_id;
	String content;
	String star_score;
	String review_date;
	String reservation_id;
	String movies_id;

	public Ad_Riview_Data(String review_id, String content, String star_score, String review_date,
			String reservation_id, String movies_id) {
		super();
		this.review_id = review_id;
		this.content = content;
		this.star_score = star_score;
		this.review_date = review_date;
		this.reservation_id = reservation_id;
		this.movies_id = movies_id;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStar_score() {
		return star_score;
	}

	public void setStar_score(String star_score) {
		this.star_score = star_score;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getMovies_id() {
		return movies_id;
	}

	public void setMovies_id(String movies_id) {
		this.movies_id = movies_id;
	}

	@Override
	public String toString() {
		return "Ad_Riview_Data [review_id=" + review_id + ", content=" + content + ", star_score=" + star_score
				+ ", review_date=" + review_date + ", reservation_id=" + reservation_id + ", movies_id=" + movies_id
				+ "]";
	}

}
