package com.front.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {
    //private Long id;
    private String number;
    private List<ItemDto> items = new ArrayList<>();
    //private CustomerDto customerDto;
    private LocalDate dateOfInvoice;
    private LocalDate dateOfPayment;
    InvoiceStatus isPaid;
    private double netto;
    private double brutto;
}
