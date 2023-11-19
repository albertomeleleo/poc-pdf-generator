package com.agm.poc.service;

import com.agm.poc.dto.DishForCountDTO;
import com.lowagie.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class GeneratePDFService {

    public static final String COLUMN_1 = "Ricetta";
    public static final String COLUMN_2 = "Quantità";
    public static final String COLUMN_3 = "Note";
    public static final int SECOND_COLUMN_X = 200;
    public static final int THIRD_COLUMN_X = 100;

    public byte[] generaPDFThymeleaf(List<DishForCountDTO> dishList, String nomeFile, Date data, String hubName){
        try {
            return generatePdfFromHtml(parseThymeleafTemplate(dishList,nomeFile,data,hubName));
        } catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseThymeleafTemplate(List<DishForCountDTO> dishList, String nomeFile, Date date, String hubName) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("templates/");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("date", date);
        context.setVariable("dishList", dishList);
        context.setVariable("hubName", hubName);

        return templateEngine.process("produzione_template", context);
    }

    public byte[]  generatePdfFromHtml(String html) throws IOException, DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(baos);

       return baos.toByteArray();
    }

}
