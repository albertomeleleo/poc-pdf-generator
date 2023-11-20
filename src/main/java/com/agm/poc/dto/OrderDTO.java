package com.agm.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDTO {
    private Long id;
    private String idShopTCPOS;
    private String richiedenteOriginale;
    private String richiedente;
    private String orario;
    private String consegna;
    private String stato;
    private String tipoPagamento;
    private String pagamento;
    private String indirizzo;
    private String indirizzoConsegna;
    private String ordinazione;
    private Date dataPrenotazione;
    private Date orarioOpzioneRitiro;
    private String orarioRitiro;
    private String tipoRitiro;
    private String luogoRitiro;
    private String stato360;
    private boolean takeaway;
    private boolean consegnaDomicilio;

    
}
