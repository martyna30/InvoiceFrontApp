package com.front.invoice;

import com.front.invoice.mapper.InvoiceMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class InvoiceForm extends FormLayout {

    public InvoiceForm(){};

    InvoiceMapper invoiceMapper = new InvoiceMapper();

    MainView mainView;

    //private TextField ls = new TextField("Lp");
    private TextField numberDocument = new TextField("Number document");
    private TextField customer = new TextField("Customer");
    private TextField datePayment = new TextField("Date payment");
    private TextField netSum = new TextField("Net sum");
    private TextField bruttoSum = new TextField("Brutto sum");
    private ComboBox status = new ComboBox<>("Invoice status");

    private InvoiceService invoiceService = InvoiceService.getInstance();

    private Binder<Invoice> binder = new Binder<>(Invoice.class);

    private Button addInvoice = new Button("Add Invoice");
    private Button deleteInvoice = new Button("Delete Invoice");

    public InvoiceForm(MainView mainView) {
        this.mainView = mainView;
        status.setItems(InvoiceStatus.values());
        HorizontalLayout buttons = new HorizontalLayout(addInvoice, deleteInvoice);
        addInvoice.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(numberDocument, customer, datePayment, netSum, bruttoSum, status, buttons);
        binder.bindInstanceFields(this);

        addInvoice.addClickListener(event -> addInvoice());
        deleteInvoice.addClickListener(event -> deleteInvoice());
    }

    public void addInvoice() {
        Invoice invoice = binder.getBean();
        InvoiceDto invoiceDto = invoiceMapper.mapToInvoiceDto(invoice);
        invoiceService.createInvoice(invoiceDto);
        mainView.refresh();
        setInvoice(null);
    }

    public void deleteInvoice() {
        Invoice invoice = binder.getBean();
        invoiceService.deleteInvoice(invoice);
        mainView.refresh();
        setInvoice(null);
    }

    public void setInvoice(Invoice invoice) {
        binder.setBean(invoice);

        if (invoice == null) {
            setVisible(false);
        } else {
            setVisible(true);
            numberDocument.focus();
        }
    }
}
