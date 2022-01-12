package com.ioco.technicalassesment;

import com.ioco.technicalassesment.exception.ResourceNotFoundException;
import com.ioco.technicalassesment.models.Invoice;
import com.ioco.technicalassesment.models.LineItem;
import com.ioco.technicalassesment.repository.InvoiceRepository;
import com.ioco.technicalassesment.service.InvoiceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TechnicalAssesmentApplicationTest {

    @InjectMocks
    protected InvoiceServiceImpl invoiceService;

    @Mock
    protected InvoiceRepository invoiceRepository;


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddInvoice() {
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(createInvoice());
        Invoice invoice = invoiceService.saveInvoice(createInvoice());
        Assert.assertEquals("Xyz",invoice.getClient());
    }

    @Test
    public void testfindAllInvoice() {
        when(invoiceRepository.findAll()).thenReturn(Arrays.asList(createInvoice()));
        List<Invoice> invoice = invoiceService.findAllInvoices();
        Assert.assertEquals("Xyz",invoice.get(0).getClient());
    }

    @Test
    public void testfindInvoiceById() throws ResourceNotFoundException {
        when(invoiceRepository.findById(1L)).thenReturn(Optional.of(createInvoice()));
        Invoice invoice = invoiceService.findInvoiceById(1L);
        Assert.assertEquals("Xyz",invoice.getClient());
    }

    @Test
    public void testfindInvoiceByIdWhenIdDoesnotExist(){
        Assert.assertThrows(ResourceNotFoundException.class, () -> invoiceService.findInvoiceById(60L));
    }


    private Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setClient("Xyz");
        invoice.setInvoiceDate(new Date());
        invoice.setVatRate(2L);
        invoice.setId(1L);
        List<LineItem> lineItemList = new ArrayList<>();
        LineItem lineItem = new LineItem();
        lineItem.setId(1L);
        lineItem.setDescription("Abc");
        lineItem.setQuantity(30L);
        lineItem.setUnitPrice(new BigDecimal(10));
        lineItemList.add(lineItem);
        invoice.setLineItems(lineItemList);
        return invoice;
    }
}
