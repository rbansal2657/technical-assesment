package com.ioco.technicalassesment.controller;

import com.ioco.technicalassesment.exception.ResourceNotFoundException;
import com.ioco.technicalassesment.models.Invoice;
import com.ioco.technicalassesment.repository.InvoiceRepository;
import com.ioco.technicalassesment.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping(value = "invoices",produces = "application/json")
    public Invoice addInvoice(@Valid @RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }


    @GetMapping(value = "invoices",produces = "application/json")
    public List<Invoice> viewAllInvoices(){
        return invoiceService.findAllInvoices();
    }


    @GetMapping(value = "invoices/{invoiceId}",produces = "application/json")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("invoiceId") Long invoiceId) throws ResourceNotFoundException {
        Invoice invoice = invoiceService.findInvoiceById(invoiceId);
        return ResponseEntity.ok().body(invoice);
    }


}

