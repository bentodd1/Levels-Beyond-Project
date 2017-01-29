package com.bentodd.assignment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Note")
public class Note {
	private long id;
	private String body;

	public Note() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
