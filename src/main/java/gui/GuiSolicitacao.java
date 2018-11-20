/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.SolicitacaoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Solicitacao;

/**
 *
 * @author Felipe Cardozo
 */
@Named(value = "guiSolicitacao")
@SessionScoped
public class GuiSolicitacao implements Serializable {
    @EJB
    SolicitacaoDao solicitacaoDao;
    
    private List<Solicitacao> solicitacoes;
    private Solicitacao solicitacao;
    private Boolean alterando = false;

    /**
     * Creates a new instance of GuiComprasFuturas
     */
    public GuiSolicitacao() {
    }
    
    public String abrir() {
        solicitacoes = solicitacaoDao.getSolicitacoes();
        return "LstSolicitacoes";
    }
    
    public String incluir() {
        this.solicitacao = new Solicitacao();
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
        return "LstSolicitacoes";
    }
    
    public String gravar() {
        if (alterando) {
            solicitacaoDao.alterar(solicitacao);
        } else {
            solicitacaoDao.incluir(solicitacao);
        }
        return abrir();
    }
    
    public String voltar(){
        return abrir();
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
}
