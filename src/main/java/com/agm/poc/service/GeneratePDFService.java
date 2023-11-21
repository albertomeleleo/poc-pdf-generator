package com.agm.poc.service;

import com.agm.poc.dto.*;
import com.agm.poc.enumeration.PdfTemplate;
import com.agm.poc.enumeration.PdfType;
import com.lowagie.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class GeneratePDFService {


    public OrderingMapper orderingMapper;
    public static final String SUFFIX_HTML = ".html";
    public static final String TEMPLATES_PATH = "templates/";
    public static final String UTF_8 = "UTF-8";


    
    public byte[] generaPDFProduction(List<DishForCountDTO> dishList, Date data, String hubName){
        try {
            return generatePdfFromHtml(parseThymeleafTemplate(dishList,data,hubName, PdfTemplate.PRODUCTION_TEMPLATE.toString(), PdfType.PRODUCTION));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] generaPDFTicket(List<DishForCountDTO> dishList, Date data, String hubName){
        try {
            return generatePdfFromHtml(parseThymeleafTemplate(dishList,data,hubName, PdfTemplate.TICKET_TEMPLATE.toString(), PdfType.TICKET));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String parseThymeleafTemplate(List<DishForCountDTO> dishList,  Date date, String hubName,String template, PdfType pdfType)  {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(SUFFIX_HTML);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix(TEMPLATES_PATH);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        String retval ="";
        switch (pdfType){
            case PRODUCTION:
                context.setVariable("date", date);
                context.setVariable("dishList", dishList);
                context.setVariable("hubName", hubName);
                retval = templateEngine.process(template, context);
                break;
            case TICKET:
                context.setVariable("date", date);
                context.setVariable("dishList", dishList);
                context.setVariable("hubName", hubName);
                retval = templateEngine.process(template, context);
                break;
            case DISH:
                break;
            default:
                break;

        }
        return retval;
    }

    public byte[]  generatePdfFromHtml(String html) throws IOException, DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(baos);

       return baos.toByteArray();
    }

    public List<DishForCountDTO> createDataForTicketPdf(List<OrderDTO> orders) {
        return createDataForProductionPdf(orders);

    }

    public List<DishForCountDTO> createDataForProductionPdf(List<OrderDTO> orders) {
        List<DishForCountDTO> dishList = new ArrayList<>();

        for (OrderDTO order : orders) {
            OrderingDTO ordering = orderingMapper.mapJsonOrderingToDTO(order.getOrdinazione());
            if (ordering != null) {
                List<MenuCartDTO> menuList = ordering.getMenu();

                for (MenuCartDTO menu : menuList) {
                    for (ArticleCartDTO article : menu.getComponenti()) {
                        updateDishListForProductionPDF(dishList, article);
                    }
                }
            }
        }

        return dishList;
    }

    private void updateDishListForProductionPDF(List<DishForCountDTO> dishList, ArticleCartDTO article) {
        Optional<DishForCountDTO> existingDish = dishList.stream()
                .filter(dish -> dish.getId().equals(article.getId()))
                .findFirst();

        if (existingDish.isPresent()) {
            existingDish.get().setQuantity(existingDish.get().getQuantity() + 1);
        } else {
            dishList.add(DishForCountDTO.builder()
                    .id(article.getId())
                    .name(article.getNome())
                    .category(article.getNomeCategoria())
                    .quantity(1)
                    .build());
        }
    }


}
