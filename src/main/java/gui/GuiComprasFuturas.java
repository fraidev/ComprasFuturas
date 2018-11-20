/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.UsuarioXml;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Solicitacao;
import model.Usuario;

/**
 *
 * @author Felipe Cardozo
 */
@Named(value = "guiComprasFuturas")
@SessionScoped
public class GuiComprasFuturas implements Serializable {
    private List<Solicitacao> solicitacoes;
    private Solicitacao solicitacao;
    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();
    private UsuarioXml usuarioXml = new UsuarioXml();
    private Boolean alterando = false;

    /**
     * Creates a new instance of GuiComprasFuturas
     */
    public GuiComprasFuturas() {
    }
    
    public String iniciar(){
//        solicitacoes = solicitacaoDao.getSolicitacoes();
        usuarios = usuarioXml.getLista();
        
        try {
            for (Usuario u: usuarios){
                if(u.getNomeDeUsuario().equals(this.usuario.getNomeDeUsuario()) && u.getSenha().equals(this.usuario.getSenha())){
                    return "Dashboard";
                }
            }
        }
        catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        return "";
    }
    
    public String cadastrar(){
        try {
            usuarioXml.gravar(this.usuario);
        }
        catch (Exception e) {
            exibirMensagem(e.getMessage());
            return "";
        }
        return "Dashboard";
    }
    
    public void exibirMensagem(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setDetail(mensagem);
        message.setSummary(mensagem);
        context.addMessage(null, message);
    }
    
    public String goToSolicitacoes(){
        return "LstSolicitacoes";
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }
    
    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
