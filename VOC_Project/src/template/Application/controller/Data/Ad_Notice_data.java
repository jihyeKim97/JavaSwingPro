package template.Application.controller.Data;

public class Ad_Notice_data {

	private int noticeid;
	private String title;
	private String content;
	private int memberid;

	public Ad_Notice_data(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public Ad_Notice_data(int noticeid, String title, String content) {
		super();
		this.noticeid = noticeid;
		this.title = title;
		this.content = content;
	}

	public Ad_Notice_data(int noticeid, String title, String content, int memberid) {
		super();
		this.noticeid = noticeid;
		this.title = title;
		this.content = content;
		this.memberid = memberid;
	}

	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	@Override
	public String toString() {
		return "Ad_Notice_data [noticeid=" + noticeid + ", title=" + title + ", content=" + content + ", memberid="
				+ memberid + "]";
	}

}
