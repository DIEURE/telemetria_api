package com.autenticatelemetria.enums;

public enum TipoAcesso {

	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");
	
	private Integer codigo;
	private String descricao;
	
	private TipoAcesso(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAcesso toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoAcesso x : TipoAcesso.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("TipoAcesso inválido");
	}
}
