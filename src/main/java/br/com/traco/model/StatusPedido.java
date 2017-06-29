package br.com.traco.model;

public enum StatusPedido {
	
	ABERTO ("aberto"),
	FECHADO ("fechado");
	
	private String descricao;
	
StatusPedido(String descricao){
	this.descricao = descricao;
	
}

public String getDescricao() {
	return descricao;
}



	
	
}
