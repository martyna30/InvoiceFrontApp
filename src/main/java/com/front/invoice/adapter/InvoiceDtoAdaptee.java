package com.front.invoice.adapter;

import com.front.invoice.Invoice;
import com.front.invoice.InvoiceDto;
import com.front.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InvoiceDtoAdaptee implements InvoiceDtoAdapter {

    @Autowired
    InvoiceDtoProcessor theProcessor;


    @Override
    public void createInvoice(InvoiceDto invoiceDto) {
        theProcessor.createInvoice(invoiceDto);
    }

    @Override
    public List<InvoiceDto> getMyListInvoicesDto() {
      return theProcessor.getMyListInvoicesDto();
    }
}
