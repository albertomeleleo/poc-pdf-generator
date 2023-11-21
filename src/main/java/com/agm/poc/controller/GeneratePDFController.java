package com.agm.poc.controller;

import com.agm.poc.enumeration.PdfType;
import com.agm.poc.service.GeneratePDFService;
import com.agm.poc.service.MockOrders;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.Date;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/pdf")
public class GeneratePDFController {

    public final GeneratePDFService generatePDFService;
    public final MockOrders mockOrders;
    @GetMapping("/generaPDF/{type}")
    public ResponseEntity<Resource> generaPDF(@RequestParam Long hubId,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                              @RequestParam String hubName,
                                              @PathVariable("type") PdfType pdfType  ) throws IOException, NotFoundException {

            StringBuilder fileName = new StringBuilder();
            //byte[] pdfContent = generatePDFService.generaPDFThymeleaf(mockOrders.generateMockCount(),date,hubName);
            byte[] pdfContent = null;
            switch(pdfType){
                case PRODUCTION:
                    fileName.append("riepilogo_produzione_").append(hubName) ;
                    pdfContent = generatePDFService.generaPDFProduction(generatePDFService.createDataForProductionPdf(mockOrders.getMockOrders()),date,hubName);
                    break;
                case DISH:
                    fileName.append("riepilogo_portata_").append(hubName) ;
                    log.error("PDF not allowed {}",PdfType.DISH.toString());
                    break;
                case TICKET:
                    fileName.append("riepilogo_etichette_").append(hubName) ;
                    pdfContent = generatePDFService.generaPDFTicket(generatePDFService.createDataForTicketPdf(mockOrders.getMockOrders()),date,hubName);
                    break;
                default:
                    log.error("PDF not allowed ");
                    break;
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
            if(pdfContent != null){
                ByteArrayResource resource = new ByteArrayResource(pdfContent);
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(pdfContent.length)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(resource);
            }else{
                return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).build();
            }
    }
}
