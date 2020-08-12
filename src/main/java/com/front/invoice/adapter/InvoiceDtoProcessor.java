package com.front.invoice.adapter;

import com.front.invoice.Invoice;
import com.front.invoice.InvoiceDto;
import com.front.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InvoiceDtoProcessor implements InvoiceDtoAdapter {

    @Autowired
    InvoiceService invoiceService;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) {
        invoiceService.createInvoice(invoiceDto);
    }

    @Override
    public List<InvoiceDto> getMyListInvoicesDto() {
        return invoiceService.getMyListInvoicesDto();
    }
}
