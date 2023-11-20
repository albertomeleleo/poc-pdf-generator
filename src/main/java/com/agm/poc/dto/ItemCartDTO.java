package it.elior.carrello.dto;

import lombok.Data;

@Data
public abstract class ItemCarrelloDTO {

	private Long id;
	private String nome;
	private Double prezzo;
	private Double punto;
	private boolean extra = false;
	private String idTCPOS;
	private boolean forcePrice;
	private String idVmRitiro;
	private String luogoRitiro;
	private String scompartoRitiro;
    private String statoScomparto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCarrelloDTO other = (ItemCarrelloDTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
