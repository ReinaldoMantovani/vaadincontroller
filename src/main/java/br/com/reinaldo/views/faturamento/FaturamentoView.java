package br.com.reinaldo.views.faturamento;


import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.reinaldo.views.MainLayout;

@PageTitle("Faturamento & Lançamentos")
@Route(value = "faturamento", layout = MainLayout.class)
public class FaturamentoView extends Div {
	
	public FaturamentoView() {
		 MenuBar menuBar = new MenuBar();
		 	menuBar.getStyle().setPadding("15px");
	        menuBar.setOpenOnHover(isAttached());
	        addItems(menuBar);
	        add(menuBar);
	    }

	    private void addItems(MenuBar menuBar) {

	        MenuItem lancamento = menuBar.addItem("Lançamentos");
	        lancamento.getStyle().setColor("green");
	        SubMenu shareSubMenu = lancamento.getSubMenu();
	        MenuItem onLancamentoGado = shareSubMenu.addItem("Compra de Gado");
	        SubMenu compraSubMenu = onLancamentoGado.getSubMenu();
	        compraSubMenu.addItem("Compra");
	        compraSubMenu.addItem("Compra Novilha");
	        compraSubMenu.addItem("comissão de Compra");
	        
	        MenuItem onLancamentoCarne = shareSubMenu.addItem("Compra de Carne");
	        SubMenu compraSubMenu2 = onLancamentoCarne.getSubMenu();
	        compraSubMenu2.addItem("Ordem de Compra");
	        compraSubMenu2.addItem("Compra");
	        compraSubMenu2.addItem("Romaneio (entrada)");
	        compraSubMenu2.addItem("Romaneio com osso (entrada)");
	        
	        MenuItem onLancamentoSaidaAndVenda = shareSubMenu.addItem("Saídas & Vendas");
	        SubMenu compraSubMenu3 = onLancamentoSaidaAndVenda.getSubMenu();
	        compraSubMenu3.addItem("Ordem de Venda (Pedido)");
	        compraSubMenu3.addItem("Saídas (Vendas)");
	        compraSubMenu3.addItem("Frete Avulso)");
	        compraSubMenu3.addItem("Documentação e Expotação");
	        compraSubMenu3.addItem("Contrato de Exportação");
	        compraSubMenu3.addItem("Remission (Saída)");
	        compraSubMenu3.addItem("*Punto de Venda");
	        compraSubMenu3.addItem("Romaneio (Expedição))");
	        compraSubMenu3.addItem("*Logistica Entraga");
	        compraSubMenu3.addItem("Saída Avulsa");
	        compraSubMenu3.addItem("*Faturas Canceladas");

	     
	    }

}
