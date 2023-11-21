package com.agm.poc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PdfTemplate {
    PRODUCTION_TEMPLATE ("production_template"),
    DISH_TEMPLATE("dish_template"),
    TICKET_TEMPLATE("ticket_template");
    @Getter
    private final String pdfValue;
}
