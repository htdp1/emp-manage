package com.htdp1.empmanage.controller;

import lombok.Data;

@Data
public class ResponseMessage {

	private ResponseStatusEnum status;
	private String message;
	private Object data;

	public ResponseMessage() {
		this.status = ResponseStatusEnum.BAD_REQUEST;
		this.data = null;
		this.message = null;
	}
}