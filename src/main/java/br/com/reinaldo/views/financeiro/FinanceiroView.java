package br.com.reinaldo.views.financeiro;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.reinaldo.views.MainLayout;

@PageTitle("Financeiro")
@Route(value = "financeiro", layout = MainLayout.class)
public class FinanceiroView extends Div {
	
	 public FinanceiroView() {
		 Tab titles = new Tab("Titulos & Baixas");
	        Tab downCollection = new Tab("Baixas Coletivas");
	        Tab centerBol = new Tab("Central de Boletoa");

	        Tabs tabs = new Tabs(titles, downCollection, centerBol);
	        tabs.addThemeVariants(TabsVariant.LUMO_CENTERED);
	        add(tabs);
	    }

}
