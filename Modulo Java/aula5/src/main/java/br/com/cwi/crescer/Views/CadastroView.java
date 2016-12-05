/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Utils.FacesUtils;
import br.com.cwi.crescer.Entity.Bean.UsuarioDao;
import br.com.cwi.crescer.Entity.Usuario;
import static br.com.cwi.crescer.Utils.UserDetails.USER_AUTH;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author rafael.silva
 */
@ManagedBean
@ViewScoped
public class CadastroView implements Serializable {

    @EJB
    private UsuarioDao usuarioDao;

    private Usuario usuario;
    private List<Usuario> usuarios;

    private Long idUsuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.usuarios = usuarioDao.findAll();
        this.usuarios.sort((a, b) -> a.getIdUsuario().compareTo(b.getIdUsuario()));
        this.usuarios = usuarioDao.findAll();

    }

    public void adicionar() {
        usuarioDao.insert(usuario);
        this.init();
    }

    public String login() {
        FacesUtils.getSession().setAttribute(USER_AUTH, this.usuario);
        return "index";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "faces/cadastro.xhtml";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
