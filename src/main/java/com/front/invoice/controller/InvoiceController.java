package com.front.invoice.controller;

import com.front.invoice.InvoiceDto;
import com.front.invoice.InvoiceService;
import com.front.invoice.adapter.InvoiceAdapter;
import com.front.invoice.adapter.InvoicesAdapter;
import com.front.invoice.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoicesAdapter invoicesAdapter;

    @Autowired
    InvoiceMapper invoiceMapper;


    @RequestMapping(method = RequestMethod.POST, value = "createInvoice", consumes = APPLICATION_JSON_VALUE)
    public void createInvoice(@RequestBody InvoiceDto invoiceDto) {
        invoicesAdapter.createInvoice(invoiceDto);
        //invoiceService.createInvoice(invoiceDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getInvoices", consumes = APPLICATION_JSON_VALUE)
    public List<InvoiceDto> getInvoices() {
        return invoicesAdapter.getMyListInvoicesDto();
        //return invoiceService.getMyListInvoicesDto();
    }

}
