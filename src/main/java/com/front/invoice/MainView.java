package com.front.invoice;

import com.helger.commons.type.ITypedObject;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.DataProviderListener;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Stream;

@Route
public class MainView extends VerticalLayout {

    private InvoiceService invoiceService = InvoiceService.getInstance();
    private Grid grid = new Grid<>(Invoice.class);
    private InvoiceForm form = new InvoiceForm(this);//?
    //private TextField filter = new TextField();
    private Button addNewInvoice = new Button("Add new invoice");

    public MainView() {
        grid.setColumns("numberDocument", "customer", "datePayment", "isPaid", "netSum", "bruttoSum");
        //form.setInvoice(null);
        addNewInvoice.addClickListener(event -> {
            grid.asSingleSelect().clear();//czyszczenie
            form.setInvoice(new Invoice());//dodanie obiektu
        });
        HorizontalLayout toolbar = new HorizontalLayout(addNewInvoice);

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        form.setInvoice(null);
        setSizeFull();
        refresh();


        /*
        grid.getDataProvider().refreshItem(invoiceService.getAllInvoices());
        grid.asSingleSelect().addValueChangeListener(event -> form.setInvoice((Invoice) grid.asSingleSelect().getValue()));*/
    }

    public void refresh() {
      // grid.setItems(invoiceService.getInvoices());
        grid.setItems(invoiceService.getAllInvoices());
    }

    //filter.setPlaceholder("Filter by numberDocument");
    //filter.setClearButtonVisible(true);
    // filter.setValueChangeMode(ValueChangeMode.EAGER);
    //filter.addValueChangeListener(e -> update());
    //grid.setDataProvider(dataProvider);
    //dataProvider.refreshAll();

     /*private void update() {
        grid.setItems(invoiceService.findByNumberDocument(filter.getValue()));*/
}




