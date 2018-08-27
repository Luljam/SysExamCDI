package hspm.cdi.bean;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;


import org.springframework.util.DigestUtils;

import hspm.usuario.UsuarioRN;
import hspm.usuario.Usuario;

@RequestScoped
@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	private String senhaCriptografada;
	private List<Usuario> lista;
	private List<Usuario> filteredUsers;
	private Usuario selectedUser;
	private String destinoSalvar;
	private Date datCadastro;

	
	public String novo() {
		this.destinoSalvar = "/admin/usuarios";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "cadastro.xhtml";
	}

	public String editar() {
		this.senhaCriptografada = this.usuario.getSenha();
		return "/admin/cadastro";
	}

	public String salvar() {
		this.destinoSalvar = "/admin/usuarios";
		
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if (senha != null &&
				senha.trim().length() > 0 &&
				!senha.equals(this.confirmaSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		if (senha != null && senha.trim().length() == 0){
			this.usuario.setSenha(this.senhaCriptografada);
		}else{
			String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
			this.usuario.setSenha(senhaCripto);
		}
			
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		return this.destinoSalvar;
	}
	
	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		} else {
			this.usuario.setAtivo(true);
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		return null;
	}
	
	
	public List<Usuario> getLista(){
		if (this.lista == null){
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
	
	public Usuario getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<Usuario> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<Usuario> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}
	
	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}


}
