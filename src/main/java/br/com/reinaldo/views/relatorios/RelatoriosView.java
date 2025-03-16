package br.com.reinaldo.views.relatorios;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import br.com.reinaldo.views.MainLayout;

@PageTitle("Relatorios")
@Route(value = "relatorios", layout = MainLayout.class)
public class RelatoriosView  extends Div {

    public RelatoriosView()  {
        TextField title = new TextField("Title");
        DatePicker date = new DatePicker("Date");
        TimePicker from = new TimePicker("From");
        TimePicker to = new TimePicker("To");

        FormLayout formLayout = new FormLayout();
        formLayout.getStyle().setPadding("30px");
        formLayout.add(title, date, from, to);
        formLayout.setColspan(title, 3);
        formLayout.setResponsiveSteps(new ResponsiveStep("0", 1),
                new ResponsiveStep("500px", 3));
        add(formLayout);
    } 
	
	
}
