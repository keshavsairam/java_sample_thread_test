package com.sample.example.util;

public enum StatusEnum {
	CREATED("NEW"), CONSUMED("FULFILLED");
	private String status;

	StatusEnum(String p) {
		status = p;
	}

	String getStatus() {
		return status;
	}
}
