package it.elior.carrello.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper=true)
public class PiattoProdottoCarrelloDTO extends ItemCarrelloDTO {
	
	private String nomeCategoria;
	private Long idCategoria;
	private Boolean piattoTrue;
	private double rating;
}
