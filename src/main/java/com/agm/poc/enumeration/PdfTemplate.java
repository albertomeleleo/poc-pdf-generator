package com.agm.poc.enumeration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PdfTemplate {
    PRODUCTION_TEMPLATE ("production_template"),
    DISH_TEMPLATE("dish_template"),
    TICKET_TEMPLATE("ticket_template");

    private String pdfValue;
}
