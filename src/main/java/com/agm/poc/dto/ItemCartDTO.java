package com.agm.poc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class ItemCartDTO {

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


}
