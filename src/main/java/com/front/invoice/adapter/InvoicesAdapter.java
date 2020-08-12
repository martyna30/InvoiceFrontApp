package com.front.invoice.adapter;

import com.front.invoice.Invoice;
import com.front.invoice.InvoiceDto;
import com.front.invoice.InvoiceForm;
import com.front.invoice.InvoiceService;
import com.front.invoice.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InvoicesAdapter extends InvoiceDtoAdaptee implements InvoiceAdapter {

    InvoiceForm invoiceForm = new InvoiceForm();

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public void addInvoice() {
      invoiceForm.addInvoice();
    }

    @Override
    public void createInvoice(InvoiceDto invoiceDto) {
        super.createInvoice(invoiceDto);
    }

    @Override
    public List<InvoiceDto> getMyListInvoicesDto() {
        return invoiceService.getMyListInvoicesDto();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<InvoiceDto> invoiceDtoList = getMyListInvoicesDto();
        List<Invoice> invoices = invoiceMapper.mapToInvoiceList(invoiceDtoList);
        return invoices;
    }

}
