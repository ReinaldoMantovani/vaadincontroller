package br.com.reinaldo.views.usuarios;


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


import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.UsuariosService;
import br.com.reinaldo.views.MainLayout;

@PageTitle("Usuarios")
@Route(value = "usuarios", layout = MainLayout.class)
public class UsuariosView  extends Div{
	
	
	HorizontalLayout vert = new HorizontalLayout();

	public UsuariosView(UsuariosService usuariosService) {
	
	  
		
		 Button addNewEmi = new Button("Novo", new Icon(VaadinIcon.USER_CARD));
		 addNewEmi.addClickListener(e -> {
			 getUI().ifPresent(ui -> {
				 ui.navigate("/cadastrar-usuario");
			 });
		 });
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
	        
	        Grid<UsuariosDto> grid = new Grid<>(UsuariosDto.class, false);
	        grid.setSelectionMode(Grid.SelectionMode.MULTI);
	        grid.addColumn(UsuariosDto::getId).setHeader("Id");
	        grid.addColumn(UsuariosDto::getNome).setHeader("Nome");
	        grid.addColumn(UsuariosDto::getSobrenome).setHeader("Sobrenome");
	        grid.addColumn(UsuariosDto::getCpf).setHeader("Cpf");
	        grid.addColumn(UsuariosDto::getRg).setHeader("Rg");
	        grid.addColumn(UsuariosDto::getTipoEmitente).setHeader("Tipo Emitente");
	        grid.addColumn(UsuariosDto::getMomentoRegistro).setHeader("Momento Registro");
	        grid.addColumn(UsuariosDto::getCidade).setHeader("Cidade");
	        grid.addColumn(createStatusComponentRenderer()).setHeader("Status")
	                .setAutoWidth(true);

	        
			List<UsuariosDto> usuarios = usuariosService.getAllUsuarios();
	        grid.setItems(usuarios);
			grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

	        vert.add(grid);
	        add(search,horizontalLayout,vert);
	        
	}




	private static final SerializableBiConsumer<Span, UsuariosDto> statusComponentUpdater = (
			span, person) -> {
		boolean isAvailable = "Available".equals(person.getStatusUsuario().toString());
		String theme = String.format("badge %s",
				isAvailable ? "success" : "error");
		span.getElement().setAttribute("theme", theme);
		span.setText(person.getStatusUsuario().toString());
	};

	private static ComponentRenderer<Span, UsuariosDto> createStatusComponentRenderer() {
		return new ComponentRenderer<>(Span::new, statusComponentUpdater);
	}
	    
	   
	
 }

