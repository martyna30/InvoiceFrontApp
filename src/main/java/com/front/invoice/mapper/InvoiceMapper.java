package com.front.invoice.mapper;

import com.front.invoice.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class InvoiceMapper {
    public Invoice mapToInvoice(final InvoiceDto invoiceDto) {
        return new Invoice(
                invoiceDto.getNumber(),
               // String.valueOf(invoiceDto.getCustomerDto()),
                String.valueOf(invoiceDto.getDateOfPayment()),
                invoiceDto.getIsPaid(),
                String.valueOf(invoiceDto.getNetto()),
                String.valueOf(invoiceDto.getBrutto())
        );
    }


    public InvoiceDto mapToInvoiceDto(final Invoice invoice) {
        return new InvoiceDto(
                invoice.getNumberDocument(),
                new ArrayList<ItemDto>(),
                null,
                LocalDate.parse(invoice.getDatePayment()),
                invoice.getIsPaid(),
                Double.parseDouble(invoice.getNetSum()),
                Double.parseDouble(invoice.getBruttoSum())
        );
    }

    public List<Invoice> mapToInvoiceList(final List< InvoiceDto > invoicesDtos) {
        return invoicesDtos.stream().
                map(invoiceDto -> new Invoice(
                        invoiceDto.getNumber(),
                        //String.valueOf(invoiceDto.getCustomerDto()),
                        String.valueOf(invoiceDto.getDateOfPayment()),
                        invoiceDto.getIsPaid(),
                        String.valueOf(invoiceDto.getNetto()),
                        String.valueOf(invoiceDto.getBrutto())))
                        .collect(toList());
    }
}
