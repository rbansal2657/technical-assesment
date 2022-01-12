package com.ioco.technicalassesment.service;

import com.ioco.technicalassesment.exception.ResourceNotFoundException;
import com.ioco.technicalassesment.models.Invoice;
import com.ioco.technicalassesment.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice findInvoiceById(Long invoiceId) throws ResourceNotFoundException {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found :: " + invoiceId));
    }

    public List<Invoice> findAllInvoices(){
        return invoiceRepository.findAll();
    }

}
