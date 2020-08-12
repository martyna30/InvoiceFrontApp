package com.front.invoice.client;

import com.front.invoice.InvoiceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class InvoiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceClient.class);

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public void createMyInvoiceDto(InvoiceDto invoiceDto) {
        URI url =  UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/invoice/createInvoice")
                .build().encode().toUri();

        restTemplate.postForLocation(url, invoiceDto);

    }

    public List<InvoiceDto> getMyInvoicesListDto() {
        URI url =  UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/invoice/getInvoices")
                .build().encode().toUri();

        try {
            System.out.println(url);
            InvoiceDto[] response = restTemplate.getForObject(url, InvoiceDto[].class);
            System.out.println(response);
            return Arrays.asList(ofNullable(response).orElse(new InvoiceDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }

    }


}
