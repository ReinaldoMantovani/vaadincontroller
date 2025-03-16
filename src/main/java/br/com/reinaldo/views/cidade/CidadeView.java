package br.com.reinaldo.views.cidade;


import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.Style.AlignItems;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.reinaldo.dto.CidadeDto;
import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.CidadeService;
import br.com.reinaldo.views.MainLayout;

@PageTitle("Cidades")
@Route(value = "cidade", layout = MainLayout.class)
public class CidadeView  extends Div{
	
	
	HorizontalLayout vert = new HorizontalLayout();

	public CidadeView(CidadeService cidadeService) {
	
	  
		
		 Button addNewEmi = new Button("Novo", new Icon(VaadinIcon.USER_CARD));
		 
	        Button editarEmi = new Button("Editar",new Icon(VaadinIcon.EDIT));
	        
	        Icon trash = new Icon(VaadinIcon.TRASH);
	        trash.getStyle().setColor("red");
	        Button excluirEmi = new Button("Excluir", trash);
	        excluirEmi.addAttachListener(event -> {
	        	
	        });
	        Icon atualizar = new Icon(VaadinIcon.ARROW_CIRCLE_UP);
	        trash.getStyle().setColor("Blue");
	        Button atualizarButton = new Button("Atualizar", atualizar);
         
	        HorizontalLayout horizontalLayout = new HorizontalLayout(addNewEmi, editarEmi, excluirEmi, atualizarButton);
	        horizontalLayout.getStyle().setPadding("10px");
	        horizontalLayout.getStyle().setMarginTop("-20px");
	       
	        TextField textField = new TextField();
	        textField.setPlaceholder("Search");
	        textField.setPrefixComponent(new Icon("lumo", "search"));
	        textField.setTooltipText("Buscar por: id ou descrição");
	        
	        VerticalLayout search = new VerticalLayout(textField);
	        search.getStyle().setAlignItems(AlignItems.NORMAL);
	        search.getStyle().setMarginTop("10px");
	        search.getStyle().setWidth("500px");
	        
	        Grid<CidadeDto> grid = new Grid<>(CidadeDto.class, false);
	        grid.setSelectionMode(Grid.SelectionMode.MULTI);
	        grid.addColumn(CidadeDto::getId).setHeader("Id").setSortable(true);
	        grid.addColumn(CidadeDto::getNome).setHeader("Nome").setSortable(true);
	        grid.addColumn(CidadeDto::getCodigoIbge).setHeader("CodigoIbge").setSortable(true);
	        grid.addColumn(CidadeDto::getUf).setHeader("Uf").setSortable(true);
	        grid.addColumn(CidadeDto::getMomentoRegistro).setHeader("MomentoRegistro").setSortable(true);
	        
	       
			List<CidadeDto> cidades = cidadeService.getAllCidades();
	        grid.setItems(cidades);
			grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	        
	        vert.add(grid);
	        add(search,horizontalLayout,vert);
	        
	}
		
 }

