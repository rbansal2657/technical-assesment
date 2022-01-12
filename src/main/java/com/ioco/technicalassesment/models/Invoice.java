package com.ioco.technicalassesment.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String client;

    @Column
    private Long vatRate;

    @Column
    private Date invoiceDate;

    @OneToMany(targetEntity=LineItem.class,cascade=CascadeType.ALL)
    private List<LineItem> lineItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }


    public BigDecimal getSubTotal(){
        return new BigDecimal(lineItems.stream().mapToDouble(lineItem -> (new BigDecimal(lineItem.getQuantity()).multiply(lineItem.getUnitPrice()).doubleValue())).sum()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVat(){
        return (getSubTotal().multiply(new BigDecimal(vatRate)).divide(new BigDecimal(100),BigDecimal.ROUND_HALF_UP)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal(){
            return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }
}
