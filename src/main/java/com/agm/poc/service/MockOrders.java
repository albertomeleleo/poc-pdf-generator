package com.agm.poc.service;

import com.agm.poc.dto.DishForCountDTO;
import com.agm.poc.dto.OrderDTO;
import com.agm.poc.dto.OrderingDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
public class MockOrders {
    public static final String JSON = "{\"showCreditCard\":true,\"showPaypal\":true,\"showEwallet\":true,\"realTotal\":1.81,\"totalB2b\":null,\"totalB2c\":1.81,\"showTotal\":true,\"subsidyCode\":null,\"menu\":[{\"id\":10000,\"nome\":\"Pasto\",\"prezzo\":1.81,\"punto\":null,\"extra\":false,\"idTCPOS\":\"2481\",\"forcePrice\":true,\"idVmRitiro\":null,\"luogoRitiro\":null,\"scompartoRitiro\":null,\"statoScomparto\":null,\"componenti\":[{\"id\":2928444,\"nome\":\"Fusilli al salmone \\\"i Colti\\\"\",\"prezzo\":0.0,\"punto\":0.0,\"extra\":false,\"idTCPOS\":\"2481\",\"forcePrice\":false,\"idVmRitiro\":null,\"luogoRitiro\":null,\"scompartoRitiro\":null,\"statoScomparto\":null,\"nomeCategoria\":\"Primi\",\"idCategoria\":1,\"piattoTrue\":true,\"rating\":0.0},{\"id\":2928453,\"nome\":\"Paillard di maiale con bieta tricolore \\\"i Colti\\\"\",\"prezzo\":0.0,\"punto\":0.0,\"extra\":false,\"idTCPOS\":\"2481\",\"forcePrice\":false,\"idVmRitiro\":null,\"luogoRitiro\":null,\"scompartoRitiro\":null,\"statoScomparto\":null,\"nomeCategoria\":\"Secondo e contorno\",\"idCategoria\":1356,\"piattoTrue\":true,\"rating\":0.0},{\"id\":55880,\"nome\":\"Acqua naturale LT 0,5\",\"prezzo\":0.21,\"punto\":0.0,\"extra\":false,\"idTCPOS\":\"2480\",\"forcePrice\":false,\"idVmRitiro\":null,\"luogoRitiro\":null,\"scompartoRitiro\":null,\"statoScomparto\":null,\"nomeCategoria\":\"Acqua\",\"idCategoria\":1239,\"piattoTrue\":false,\"rating\":0.0},{\"id\":55907,\"nome\":\"Pane\",\"prezzo\":0.0,\"punto\":0.0,\"extra\":false,\"idTCPOS\":\"2480\",\"forcePrice\":false,\"idVmRitiro\":null,\"luogoRitiro\":null,\"scompartoRitiro\":null,\"statoScomparto\":null,\"nomeCategoria\":\"Pane\",\"idCategoria\":15,\"piattoTrue\":false,\"rating\":0.0}]}],\"singoli\":[],\"subscriptions\":[],\"carnets\":[],\"articles\":[],\"totale\":1.81,\"totalePunti\":null,\"promo\":{\"totaleCarrello\":null,\"totaleCarrelloScontato\":null,\"totaleRicarica\":null,\"messaggiPromo\":null,\"articoliOmaggio\":null,\"promoApplicateOrdine\":null,\"promoApplicateRicarica\":null},\"promoFuture\":{\"messaggiPromo\":null,\"promoDaApplicare\":null},\"hidePrezziCarrelloOrdini\":false,\"enabled\":true,\"message\":\"\",\"snackNumber\":null,\"carrelloOriginale\":{\"carrello\":[{\"id\":2928444,\"idCategoria\":1,\"nomeCategoria\":\"Primi\",\"nome\":\"Fusilli al salmone \\\"i Colti\\\"\",\"piattoTrue\":true,\"quantita\":1,\"prezzo\":0.0,\"prezzoAddon\":0.0,\"punto\":0.0,\"idTCPOS\":\"2481\",\"extra\":false,\"SubscriptionID\":null,\"CarnetID\":null,\"idJfs\":null,\"photo\":null,\"articleID\":null,\"articleName\":null,\"typeObj\":null,\"dose\":null,\"StartDate\":null},{\"id\":2928453,\"idCategoria\":1356,\"nomeCategoria\":\"Secondo e contorno\",\"nome\":\"Paillard di maiale con bieta tricolore \\\"i Colti\\\"\",\"piattoTrue\":true,\"quantita\":1,\"prezzo\":0.0,\"prezzoAddon\":0.0,\"punto\":0.0,\"idTCPOS\":\"2481\",\"extra\":false,\"SubscriptionID\":null,\"CarnetID\":null,\"idJfs\":null,\"photo\":null,\"articleID\":null,\"articleName\":null,\"typeObj\":null,\"dose\":null,\"StartDate\":null},{\"id\":55880,\"idCategoria\":1239,\"nomeCategoria\":\"Acqua\",\"nome\":\"Acqua naturale LT 0,5\",\"piattoTrue\":false,\"quantita\":1,\"prezzo\":0.21,\"prezzoAddon\":0.0,\"punto\":0.0,\"idTCPOS\":\"2480\",\"extra\":false,\"SubscriptionID\":null,\"CarnetID\":null,\"idJfs\":null,\"photo\":null,\"articleID\":null,\"articleName\":null,\"typeObj\":null,\"dose\":null,\"StartDate\":null},{\"id\":55907,\"idCategoria\":15,\"nomeCategoria\":\"Pane\",\"nome\":\"Pane\",\"piattoTrue\":false,\"quantita\":1,\"prezzo\":0.0,\"prezzoAddon\":0.0,\"punto\":0.0,\"idTCPOS\":\"2480\",\"extra\":false,\"SubscriptionID\":null,\"CarnetID\":null,\"idJfs\":null,\"photo\":null,\"articleID\":null,\"articleName\":null,\"typeObj\":null,\"dose\":null,\"StartDate\":null}],\"punti\":null},\"messageList\":{},\"limiteVassoi\":{\"counter\":[{\"state\":\"vassoiAcquistati\",\"numberOfElements\":0},{\"state\":\"limiteVassoiAcquistabili\",\"numberOfElements\":1},{\"state\":\"acquistabili\",\"numberOfElements\":1},{\"state\":\"limiteSingoliAcquistabili\",\"numberOfElements\":0},{\"state\":\"limiteMinimoAcquisti\",\"numberOfElements\":0}],\"stato\":\"ACQUISTO_ABILITATO\",\"abilitato\":true,\"messaggio\":\"\"},\"tentataVendita\":{\"now\":null,\"abilitato\":true,\"messaggio\":null,\"stato\":null,\"oggettoErrore\":null,\"tentataVendita\":false},\"isPromo\":false}";

    public List<OrderDTO> getMockOrders(){
        List<OrderDTO> orders = new ArrayList<>();
        for (int i =0 ;  i < 30; i++){
            OrderDTO order = OrderDTO.builder()
                    .id(Integer.toUnsignedLong(i))
                    .ordinazione(JSON)
                    .build();
            orders.add(order);
        }
        return orders;
    }

    public List<DishForCountDTO> generateMockCount(){
        List<DishForCountDTO> dishList = new ArrayList<>();
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        return dishList;
    }
}
