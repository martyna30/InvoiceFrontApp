package com.front.invoice.adapter;

import com.front.invoice.Invoice;
import com.front.invoice.InvoiceDto;

import java.util.List;

public interface InvoiceDtoAdapter {
   void createInvoice(InvoiceDto invoiceDto);

   List<InvoiceDto> getMyListInvoicesDto();

}
