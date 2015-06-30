package br.com.tcc.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.tcc.dao.UsuarioDao;
import br.com.tcc.enumClasse.TipoUsuario;
import br.com.tcc.modelo.Usuario;
import br.com.tcc.util.FacesMessages;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioDao dao;
	
	@Inject
	private FacesMessages messages;
	
	private List<Usuario> usuarios;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void grava() {
		dao.adiciona(usuario);
		messages.info("Usuário Cadastrado com Sucesso!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msg-user"));
		this.usuario = new Usuario();
	}
	
	public TipoUsuario[] getTipousuario(){  
        return TipoUsuario.values();  
    }
	
	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			System.out.println("Carregando Usuarios");
			this.usuarios = dao.listaTodos();
		}
		return usuarios;
	}

}
