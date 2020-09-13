package com.viit.smartcradle.entity;

import java.io.Serializable;

public class PostResponseBody implements Serializable {
	private static final long serialVersionUID = 1L;

	private Status status;

	public PostResponseBody() {
		super();
	}

	public PostResponseBody(Status status) {
		super();
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
}
