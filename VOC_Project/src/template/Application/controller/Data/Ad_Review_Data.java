package template.Application.controller.Data;

public class Ad_Review_Data {

	private int review_id;
	private String content;
	public Ad_Review_Data(String content) {
		super();
		this.content = content;
	}
	public Ad_Review_Data(int review_id) {
		super();
		this.review_id = review_id;
	}
	public Ad_Review_Data(int review_id, String content) {
		super();
		this.review_id = review_id;
		this.content = content;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Ad_Review_Data [review_id=" + review_id + ", content=" + content + "]";
	}

}

