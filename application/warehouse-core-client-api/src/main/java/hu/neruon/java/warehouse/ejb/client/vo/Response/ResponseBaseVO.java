package hu.neruon.java.warehouse.ejb.client.vo.Response;

import java.io.Serializable;

class ResponseBaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String resultMessage;

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
