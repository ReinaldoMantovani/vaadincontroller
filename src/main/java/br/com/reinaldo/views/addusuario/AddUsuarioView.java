package br.com.reinaldo.views.addusuario;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.enums.StatusUsuario;
import br.com.reinaldo.enums.TipoEmitenteEnum;
import br.com.reinaldo.service.UsuariosService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@PageTitle("Cadastrar usuario")
@Route(value = "cadastrar-usuario")
public class AddUsuarioView extends VerticalLayout {

	private final UsuariosService usuariosService;

	@PropertyId("nome")
	private TextField nome;
	@PropertyId("sobrenome")
	private TextField sobrenome;
	@PropertyId("statusUsuario")
	private ComboBox<StatusUsuario> statusUsuario;
	@PropertyId("cpf")
	private TextField cpf;
	@PropertyId("rg")
	private TextField rg;
	@PropertyId("tipoEmitente")
	private ComboBox<TipoEmitenteEnum> tipoEmitenteEnum;

	private Button saveButton;
	private Button cancelButton;
	private UsuariosDto usuario;
	private Binder<UsuariosDto> binder;

	public AddUsuarioView(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;

		setAlignItems(Alignment.CENTER);
		createVaribles();
		createBinder();
		add(createFormLayout());
	}

	private void createBinder() {
		usuario = new UsuariosDto();
		binder = new BeanValidationBinder<>(UsuariosDto.class);
		binder.bindInstanceFields(this);

		// Adicionando o binding manualmente para o ComboBox
		binder.forField(tipoEmitenteEnum)
				.asRequired("Tipo Emitente é obrigatório")
				.bind(UsuariosDto::getTipoEmitente, UsuariosDto::setTipoEmitente);
	}

	private void createVaribles() {
		nome = new TextField("Nome");
		sobrenome = new TextField("Sobrenome");
		statusUsuario = new ComboBox<>("Status do Usuario");
		statusUsuario.setItems(StatusUsuario.values()); // Preenchendo com os valores do enum
		statusUsuario.setItemLabelGenerator(StatusUsuario::name);
		cpf = new TextField("CPF");
		rg = new TextField("RG");

		// Criação do ComboBox
		tipoEmitenteEnum = new ComboBox<>("Tipo Emitente");
		tipoEmitenteEnum.setItems(TipoEmitenteEnum.values()); // Preenchendo com os valores do enum
		tipoEmitenteEnum.setItemLabelGenerator(TipoEmitenteEnum::name); // Usando o nome do enum como rótulo

		saveButton = new Button("Salvar");
		cancelButton = new Button("Cancelar");

		// Adicionando listeners aos botões
		cancelButton.addClickListener(e -> closeView());
		saveButton.addClickListener(e -> saveUsuariosDto());
	}

	private Component createFormLayout() {
		FormLayout form = new FormLayout();
		form.add(nome, sobrenome, statusUsuario, cpf, rg, tipoEmitenteEnum, createButtons());
		form.setColspan(nome, 1);
		form.setResponsiveSteps(
				// Use one column by default
				new FormLayout.ResponsiveStep("0", 1),
				// Use two columns, if layout's width exceeds 500px
				new FormLayout.ResponsiveStep("500px", 2));
		return form;
	}

	private Component createButtons() {
		saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
		return new HorizontalLayout(cancelButton, saveButton);
	}

	private void saveUsuariosDto() {
		try {
			binder.writeBean(usuario);
			usuariosService.createUsuario(usuario);
			clearField();
		} catch (ValidationException | IOException e) {
			e.printStackTrace();
		}
	}

	private void clearField() {
		usuario = new UsuariosDto();
		binder.readBean(usuario); // Limpa os campos do binder
		binder.getFields().forEach(HasValue::clear); // Limpa os campos da interface
	}

	private void closeView() {
		getUI().ifPresent(ui -> ui.navigate("/usuarios")); // Navega de volta para a lista de usuários
	}
}