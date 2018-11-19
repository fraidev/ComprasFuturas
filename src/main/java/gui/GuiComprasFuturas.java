/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SolicitacaoDao;
import dao.UsuarioXml;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.EJB;
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
    @EJB
    SolicitacaoDao solicitacaoDao;
    
    
    private List<Solicitacao> solicitacoes;
    private Solicitacao solicitacao;
    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();
    private UsuarioXml usuarioXml = new UsuarioXml();
    private Boolean alterando = false;
    private Boolean logado = false;

    /**
     * Creates a new instance of GuiComprasFuturas
     */
    public GuiComprasFuturas() {
    }
    
    public String iniciar(){
        solicitacoes = solicitacaoDao.getSolicitacoes(usuario.getNomeDeUsuario());
        usuarios = usuarioXml.getLista();
        
        try {
            if(!logado){
                for (Usuario u: usuarios){
                    if(u.getNomeDeUsuario().equals(this.usuario.getNomeDeUsuario()) && u.getSenha().equals(this.usuario.getSenha())){
                        if(alterando == false){
                            usuarioXml.gravar(this.usuario);
                            logado = true;
                            return "LstSolicitacoes";
                        }else{
                            return "LstSolicitacoes";
                        }
                    }else{
                        return "";
                    }
                }
            }
        }
        catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        return "LstSolicitacoes";
    }
    
    public String cadastrar(){
        solicitacoes = solicitacaoDao.getSolicitacoes(usuario.getNomeDeUsuario());
        try {
            if(!logado){
                if (alterando == false) {
                    usuarioXml.gravar(this.usuario);
                    logado = true;
                    return "LstSolicitacoes";
                }else{
                    return "LstSolicitacoes";
                }
            }
        }
        catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        return "LstSolicitacoes";
    }
    
    public void exibirMensagem(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setDetail(mensagem);
        message.setSummary(mensagem);
        context.addMessage(null, message);
    }
    
    public String incluir() {
        solicitacao = new Solicitacao(this.usuario);
        alterando = true;
        return "CadSolicitacao";
    }

    public String alterar(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
        alterando = true;
        return "CadSolicitacao";
    }
    
    public String excluir(Solicitacao solicitacao) {
        solicitacaoDao.excluir(solicitacao);
        return iniciar();
    }
    
    public String gravar() {
        if (alterando) {
            solicitacaoDao.alterar(solicitacao);
        } else {
            solicitacaoDao.incluir(solicitacao);
        }
        return iniciar();
    }

    public SolicitacaoDao getSolicitacaoDao() {
        return solicitacaoDao;
    }

    public void setSolicitacaoDao(SolicitacaoDao solicitacaoDao) {
        this.solicitacaoDao = solicitacaoDao;
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
