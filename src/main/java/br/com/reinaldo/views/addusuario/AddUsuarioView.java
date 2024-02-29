package br.com.reinaldo.views.addusuario;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.dom.Style.AlignItems;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.reinaldo.dto.TipoEmitenteDto;
import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.TipoEmitenteService;
import br.com.reinaldo.service.UsuariosService;

@PageTitle("Cadastrar usuario")
@Route(value = "cadastrar-usuario")
public class AddUsuarioView extends VerticalLayout {
	private final TipoEmitenteService tipoEmitenteService;
	private UsuariosService usuariosService; 
	
	@PropertyId("nome")
	private TextField nome;
	@PropertyId("sobrenome")
	private TextField sobrenome;
	@PropertyId("statusUsuario")
	private TextField statusUsuario;
	@PropertyId("cpf")
	private TextField cpf;
	@PropertyId("rg")
	private TextField rg;
	@PropertyId("tipoEmitente")
	private ComboBox<TipoEmitenteDto> tipoEmitente;

	private Button saveButton;
	private Button cancelButton;
	private UsuariosDto usuario;
	private Binder<UsuariosDto> binder;
	
	public AddUsuarioView(TipoEmitenteService tipoEmitenteService, UsuariosService usuariosService) {
		this.tipoEmitenteService = tipoEmitenteService;
		this.usuariosService = usuariosService;
		
		setAlignItems(Alignment.CENTER);
		createVaribles();
		createTipoEmitente();
		createBinder();
		
		 Image logo = new Image("/images/logo.png", "Logo FjSistemas");
		 logo.getStyle().setPadding("10px");
		 logo.getStyle().setAlignItems(AlignItems.CENTER);
		 logo.getStyle().setHeight("20px");
		 logo.getStyle().setTop("15px");
		 add(logo);
		 add(createFormLayout());
	}


	private void createBinder() {
		usuario = new UsuariosDto();
		binder = new BeanValidationBinder<>(UsuariosDto.class);
		binder.bindInstanceFields(this);
		
	}


	private void createTipoEmitente() {
		List<TipoEmitenteDto> tipoEmitenteItem = tipoEmitenteService.getAllTipoEmitente();
		tipoEmitente.setItems(tipoEmitenteItem);
		tipoEmitente.setValue(tipoEmitenteItem.get(0));
		tipoEmitente.setItemLabelGenerator(TipoEmitenteDto::getNome);
	}


	private Component createFormLayout() {
		FormLayout form = new FormLayout();
		
		form.add(nome, sobrenome, statusUsuario,
				cpf, rg, tipoEmitente, createButtons());
		form.setColspan(nome, 2);
		return form;
	}


	private Component createButtons() {
		saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
		
		cancelButton.addClickListener(e -> closeView());
		
		return new HorizontalLayout(cancelButton, saveButton);
	}


	private Object closeView() {
		getUI().ifPresent(ui -> ui.navigate("/cadastro-usuarios"));
		return null;
	}


	private void createVaribles() {
		
		nome = new TextField("Nome");
		sobrenome = new TextField("Sobrenome");
		statusUsuario = new TextField("Status");
		cpf = new TextField("Cpf");
		rg = new TextField("Rg");
		tipoEmitente = new ComboBox<TipoEmitenteDto>("Tipo Emitente");
		saveButton = new Button("Salvar");
		cancelButton = new Button("Cancelar");
		
		
	}
}
