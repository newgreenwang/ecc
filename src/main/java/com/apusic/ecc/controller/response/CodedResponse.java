package com.apusic.ecc.controller.response;

/**
 * Created by mazhen on 16/6/28.
 */
public class CodedResponse {

    private int retcode;

    private String message;

    public CodedResponse(int retcode, String message) {
        this.setRetcode(retcode);
        this.message = message;
    }
    
    public CodedResponse(){
    	this.retcode = 0;
    }

	public void setMessage(String message) {
		this.message = message;
	}

	public CodedResponse(String message) {
        this.setRetcode(0);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



	public int getRetcode() {
		return retcode;
	}



	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}
}
