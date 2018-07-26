package project.to;

import java.util.Date;

public class PlayabilityTO {
	private Date startDate = new Date();
	private Date endDate = new Date();
	private String comment;

	public PlayabilityTO(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = "";
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
