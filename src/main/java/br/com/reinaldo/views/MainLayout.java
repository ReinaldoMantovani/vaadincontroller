package br.com.reinaldo.views;



import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;

import br.com.reinaldo.views.cidade.CidadeView;
import br.com.reinaldo.views.emitente.EmitenteView;
import br.com.reinaldo.views.faturamento.FaturamentoView;
import br.com.reinaldo.views.relatorios.RelatoriosView;
import br.com.reinaldo.views.usuarios.UsuariosView;


/**
 * The main view is a top-level placeholder for other views.
 */
@Route("/")
@RouteAlias(value = "", layout = MainLayout.class)
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
        }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
    	 Image logo = new Image("/images/logo.png", "Alt Text");
    	 logo.getStyle().setMaxWidth("160px");
    	 logo.getStyle().setMaxHeight("160px");
        logo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(logo);

        Scroller scroller = new Scroller(createNavigation());
       
        addToDrawer(header, scroller);
    }
    
 

    private VerticalLayout createNavigation() {
    	VerticalLayout vertical = new VerticalLayout();
    	
    	SideNav nav = new SideNav();
    	nav.getStyle().setFontSize("14px");
    	
    	 SideNavItem usuarios = new SideNavItem("Cadastro");
         usuarios.setPrefixComponent(VaadinIcon.EDIT.create());
         usuarios.addItem(new SideNavItem("Usuarios", UsuariosView.class, VaadinIcon.USER_CHECK.create()));
         usuarios.addItem(new SideNavItem("Emitentes", EmitenteView.class, VaadinIcon.USER_CARD.create()));
         usuarios.addItem(new SideNavItem("Cidade", CidadeView.class, VaadinIcon.CHECK_SQUARE.create()));
         
         
         SideNavItem faturamento = new SideNavItem("Faturamento");
         faturamento.setPrefixComponent(VaadinIcon.BARCODE.create());
         faturamento.addItem(new SideNavItem("Lançamentos", FaturamentoView.class, VaadinIcon.ARCHIVE.create()));
         

         SideNavItem relatorio = new SideNavItem("Relatório");
         relatorio.setPrefixComponent(VaadinIcon.CHART.create());
         relatorio.addItem(new SideNavItem("Inventário", RelatoriosView.class, VaadinIcon.CHART_LINE.create()));

         nav.addItem(usuarios, faturamento, relatorio);

        
         nav.setWidthFull();
  

         this.addClassName("side-nav-sample");
         
         vertical.add(nav);
         return vertical;
    }
    
   
    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
