package org.serratec.backend.infra;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ErrorResponse {
	private Integer status;
	private String message;
	private LocalDateTime timeStamp;
	private List<String> errors;
	
	public ErrorResponse(Integer status, String message, LocalDateTime timeStamp, List<String> errors) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.errors = errors;
	}
	
	
	
}
