package com.lucas.curso.resources.exception;

import java.io.Serializable;

public class StandartError  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Status ; 
	private String msg ; 
	private Long TimeStamp ;
	
	
	
	public StandartError(Integer status, String msg, Long timeStamp) {
		super();
		Status = status;
		this.msg = msg;
		TimeStamp = timeStamp;
	}



	public Integer getStatus() {
		return Status;
	}



	public void setStatus(Integer status) {
		Status = status;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Long getTimeStamp() {
		return TimeStamp;
	}



	public void setTimeStamp(Long timeStamp) {
		TimeStamp = timeStamp;
	} 
	
	
	

}
