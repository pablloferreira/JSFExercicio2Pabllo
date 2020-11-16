package br.com.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.ControleDAOPabllo;
import br.edu.faculdadedelta.modelo.ControlePabllo;

@ManagedBean
@SessionScoped
public class ControleControllerPabllo {

	private ControlePabllo cont = new ControlePabllo();
	private ControleDAOPabllo dao = new ControleDAOPabllo();
	
	public ControlePabllo getControlePabllo() {
		return cont;
	}
	
	public void setControlePabllo(ControlePabllo cont) {
		this.cont = cont;
	}
	
	
	public void limparCampos() {
		cont = new ControlePabllo();
	}
	
	public String salvar() {
		try {
			if (cont.getId() == null) {
				// incluir
				dao.incluir(cont);
				FacesMessage mensagem = new FacesMessage("Inclusão realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparCampos();
			} else {
				// alterar
				dao.alterar(cont);
				FacesMessage mensagem = new FacesMessage("Alteração realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparCampos();
			}
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "cadastroControle.xhtml";
	}
	
	public List<ControlePabllo> getLista() {
		List<ControlePabllo> listaRetorno = new ArrayList<ControlePabllo>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public String editar() {
		return "cadastroControle.xhtml";
	}
	
	public String excluir() {
		try {
			dao.excluir(cont);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "listaControle.xhtml";
	}
}

