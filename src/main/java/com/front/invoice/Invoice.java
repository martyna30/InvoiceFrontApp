package com.front.invoice;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Invoice {

    private String numberDocument;
    private String customer;
    private String datePayment;
    private InvoiceStatus isPaid;
    private String netSum;
    private String bruttoSum;

    public Invoice() {
    }
    public Invoice(String numberDocument, String datePayment, InvoiceStatus isPaid, String netSum, String bruttoSum) {
        this.numberDocument = numberDocument;
        this.datePayment = datePayment;
        this.isPaid = isPaid;
        this.netSum = netSum;
        this.bruttoSum = bruttoSum;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public InvoiceStatus getIsPaid() {
        return isPaid;
    }

    public String getNetSum() {
        return netSum;
    }

    public String getBruttoSum() {
        return bruttoSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        //if (!numberDocument.equals(invoice.numberDocument))return false;
        //if(!customer.equals(invoice.customer)) return false;

        return Objects.equals(numberDocument, invoice.numberDocument) &&
                Objects.equals(customer, invoice.customer);
    }

    @Override
    public int hashCode() {
        int result = numberDocument != null? numberDocument.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public void setIsPaid(InvoiceStatus isPaid) {
        this.isPaid = isPaid;
    }

    public void setNetSum(String netSum) {
        this.netSum = netSum;
    }

    public void setBruttoSum(String bruttoSum) {
        this.bruttoSum = bruttoSum;
    }
}
