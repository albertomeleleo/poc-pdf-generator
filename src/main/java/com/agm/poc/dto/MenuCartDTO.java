package it.elior.carrello.dto;

import java.util.ArrayList;
import java.util.List;

import flexjson.JSON;

public class MenuCarrelloDTO extends ItemCarrelloDTO {
	
	private List<PiattoProdottoCarrelloDTO> componenti;
	
	public MenuCarrelloDTO() {
		super();
		componenti = new ArrayList<>();
	}

	@JSON
	public List<PiattoProdottoCarrelloDTO> getComponenti() {
		if(componenti == null){
			componenti = new ArrayList<>();
		}
		return componenti;
	}

	public void setComponenti(List<PiattoProdottoCarrelloDTO> componenti) {
		this.componenti = componenti;
	}

}
