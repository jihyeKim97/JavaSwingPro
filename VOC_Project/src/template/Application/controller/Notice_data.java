package template.Application.controller;

public class Notice_data {

	private int NoticeId;
	private String Title;
	private String Content;
	private int ViewCount;
	private int NumberID;

	public Notice_data() {
	}

	public Notice_data(int noticeId, String title, String content, int viewCount) {
		super();
		NoticeId = noticeId;
		Title = title;
		Content = content;
		ViewCount = viewCount;
	}

	public Notice_data(int noticeId, String title, String content, int viewCount, int numberID) {
		super();
		NoticeId = noticeId;
		Title = title;
		Content = content;
		ViewCount = viewCount;
		NumberID = numberID;
	}

	@Override
	public String toString() {
		return "Notice [NoticeId=" + NoticeId + ", Title=" + Title + ", Content=" + Content + ", ViewCount=" + ViewCount
				+ ", NumberID=" + NumberID + "]";
	}

	public int getNoticeId() {
		return NoticeId;
	}

	public void setNoticeId(int noticeId) {
		NoticeId = noticeId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getViewCount() {
		return ViewCount;
	}

	public void setViewCount(int viewCount) {
		ViewCount = viewCount;
	}

	public int getNumberID() {
		return NumberID;
	}

	public void setNumberID(int numberID) {
		NumberID = numberID;
	}

}
