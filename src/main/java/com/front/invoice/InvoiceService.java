package com.front.invoice;

import com.front.invoice.client.InvoiceClient;
import com.front.invoice.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Boolean.TRUE;

@Service
public class InvoiceService {

    @Autowired
    InvoiceClient invoiceClient = new InvoiceClient();

    @Autowired
    InvoiceMapper invoiceMapper = new InvoiceMapper();

    private Set invoices;

    private static InvoiceService invoiceService;


    private InvoiceService() {

    }

    public List<Invoice> getAllInvoices() {
        List<InvoiceDto> invoiceDtoList = getMyListInvoicesDto();
        return invoiceMapper.mapToInvoiceList(invoiceDtoList);
    }

    public static InvoiceService getInstance() {
        if (invoiceService == null) {
            invoiceService = new InvoiceService();
        }
        return invoiceService;
    }

    public void createInvoice(InvoiceDto invoiceDto) {
        invoiceClient.createMyInvoiceDto(invoiceDto);
    }

    public List<InvoiceDto> getMyListInvoicesDto() {
        return invoiceClient.getMyInvoicesListDto();
    }

    public void deleteInvoice(Invoice invoice) {
        this.invoices.remove(invoice);
    }
}

