package br.com.tcc.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.tcc.dao.UsuarioDao;
import br.com.tcc.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioLogadoBean usuarioLogado;

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioDao dao;

	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			usuarioLogado.logar(usuario);
			return "menu?faces-redirect=true";
		} else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String existe() {
		if (dao.existe(this.usuario)) {
			usuarioLogado.guarda(this.usuario);
			return "menu";
		} else {
			return "login";
		}

	}

	public String sairApp() {
		usuarioLogado.deslogar();
		return "login?faces-redirect=true";
	}

}
