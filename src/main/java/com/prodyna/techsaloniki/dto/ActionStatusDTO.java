package com.prodyna.techsaloniki.dto;

public class ActionStatusDTO {
	public enum STATUS {
		OK, ERROR;
	}

	private STATUS status;
	private String msg;

	public ActionStatusDTO() {
		this.status = STATUS.OK;
	}

	public ActionStatusDTO(final STATUS status, final String msg) {
		this.status = status;
		this.msg = msg;
	}

	public STATUS getStatus() {
		return this.status;
	}

	public void setStatus(final STATUS status) {
		this.status = status;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public ActionStatusDTO signalOk() {
		this.status = STATUS.OK;

		return this;
	}

	public ActionStatusDTO signalError() {
		this.status = STATUS.ERROR;

		return this;
	}

	public ActionStatusDTO signalError(final String msg) {
		this.status = STATUS.ERROR;
		this.msg = msg;
		return this;
	}

}
