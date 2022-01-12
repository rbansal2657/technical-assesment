package com.ioco.technicalassesment.service;

import com.ioco.technicalassesment.exception.ResourceNotFoundException;
import com.ioco.technicalassesment.models.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);

    Invoice findInvoiceById(Long invoiceId) throws ResourceNotFoundException;

    List<Invoice> findAllInvoices();
}
