//package br.com.tcc.listener;
//
//import javax.faces.application.NavigationHandler;
//import javax.faces.context.FacesContext;
//import javax.faces.event.PhaseEvent;
//import javax.faces.event.PhaseId;
//import javax.faces.event.PhaseListener;
//import javax.inject.Inject;
//
//import br.com.tcc.mb.UsuarioLogadoBean;
//
//public class Autorizador implements PhaseListener {
//	
//	private static final long serialVersionUID = 1L;
//
//	@Inject
//	private UsuarioLogadoBean usuarioLogado;
//	
//	public void beforePhase(PhaseEvent event){
//		System.out.println("Antes da fase: " + event.getPhaseId());
//	}
//	
//	public void afterPhase(PhaseEvent event){
//		FacesContext context = event.getFacesContext();
//		String pagina = context.getViewRoot().getViewId();
//		if(pagina.equals("/login.xhtml")){
//			return;
//		}
//		
//		//verificacao
//		if(!usuarioLogado.isLogado()){
//			NavigationHandler handler = context.getApplication().getNavigationHandler();
//			handler.handleNavigation(context, null, "login?faces-redirect=true");
//			
//			//Efetua renderizacao da tela
//			context.renderResponse();
//		}
//	}
//	
//	public PhaseId getPhaseId(){
//		return PhaseId.RESTORE_VIEW;
//	}
//	
//	
//
//}
