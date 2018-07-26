package project.entity;

import java.util.Date;

public class PlayabilityEntity {
	private Date startDate;
	private Date endDate;
	private String comment;

	public PlayabilityEntity(Date startDate, Date endDate, String comment) {
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
