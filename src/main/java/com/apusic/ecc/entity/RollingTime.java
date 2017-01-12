package com.apusic.ecc.entity;

import org.springframework.data.annotation.Id;

public class RollingTime {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}



	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}



	@Id
	private String id;
	
	private Long time;
	
	private String documentName;
}
