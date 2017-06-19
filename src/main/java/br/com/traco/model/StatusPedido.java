package br.com.traco.model;

public enum StatusPedido {
	
	ABERTO ("aberto"),
	FECHADO ("FECHADO");
	
	private String status;
	
	StatusPedido(String status){
		this.status = status;
		
	}

	public String getStatus() {
		return status;
	}

//	public void setStatus(String status) {
//		this.status = status;
//	}

	
	
}
