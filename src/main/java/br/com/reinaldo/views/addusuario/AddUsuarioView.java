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
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@PageTitle("Cadastrar usuario")
@Route(value = "cadastrar-usuario")
public class AddUsuarioView extends VerticalLayout {

	private final UsuariosService usuariosService;

	@PropertyId("nome")
	private TextField nome;
	@PropertyId("sobrenome")
	private TextField sobrenome;
	@PropertyId("username")
	private TextField username;
	private TextField password;
	private EmailField email;
	@PropertyId("statusUsuario")
	private ComboBox<StatusUsuario> statusUsuario;
	@PropertyId("cpf")
	private TextField cpf;
	@PropertyId("rg")
	private TextField rg;
	@PropertyId("tipoEmitente")
	private ComboBox<TipoEmitenteEnum> tipoEmitenteEnum;
	private Upload profileImageUrl;

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
		username = new TextField("username");
		email = new EmailField("Email");
		email.setErrorMessage("Coloque um email valido!");
		password = new TextField("Password");
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

	private Component uploadImage() {
		MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
		profileImageUrl = new Upload(buffer);

		profileImageUrl.setAutoUpload(true);

		// Inicializando o UploadI18N e o AddFiles
		UploadI18N i18n = new UploadI18N();
		UploadI18N.AddFiles addFiles = new UploadI18N.AddFiles();
		addFiles.setMany("Upload Imagem");
		i18n.setAddFiles(addFiles); // Definindo o objeto AddFiles no UploadI18N

		profileImageUrl.setI18n(i18n);

		// Adicionando um listener para processar o arquivo após o upload
		profileImageUrl.addSucceededListener(event -> {
			String fileName = event.getFileName();
			InputStream inputStream = buffer.getInputStream(event.getFileName());

			// Aqui você pode salvar o arquivo ou fazer o que for necessário
			try {
				Files.copy(inputStream, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
				Notification.show("Erro ao salvar a imagem: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
			}
		});

		return profileImageUrl;
	}

	private Component createFormLayout() {
		FormLayout form = new FormLayout();
		form.add(nome, sobrenome,username, email ,password ,statusUsuario, cpf, rg, tipoEmitenteEnum,uploadImage(),createButtons());
		form.setColspan(nome, 1);
		form.setResponsiveSteps(
				// Use one column by default
				new FormLayout.ResponsiveStep("0", 1),
				// Use two columns, if layout's width exceeds 500px
				new FormLayout.ResponsiveStep("400", 3));
		return form;
	}

	private Component createButtons() {
		saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
		return new HorizontalLayout(cancelButton, saveButton);
	}

	private void saveUsuariosDto() {
		Notification notification = new Notification();
		try {
			binder.writeBean(usuario);
			usuariosService.createUsuario(usuario);

			clearField();
			notification.add("Usuário cadastrado com sucesso!");
			notification.setPosition(Notification.Position.TOP_CENTER);
			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
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