/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDao;
import dao.SolicitacaoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Item;
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
    @EJB
    ItemDao itemDao;
    
    private List<Solicitacao> solicitacoes;
    private Solicitacao solicitacao;
    private List<Item> itens;
    private Item item;


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
        solicitacaoDao.incluir(solicitacao);
        return abrir();
    }
    
    public String abrirCadItemSolicitacao() {
        item = new Item(solicitacao);
        return "CadItemSolicitacao";
    }
    
    public String excluir(Solicitacao solicitacao) {
        solicitacaoDao.excluir(solicitacao);
        return abrir();
    }
    
    public String abrirItensDeSolicitacao() {
        return "LstItensSolicitacao";
    }
    
    public String gravarItem() {
        itemDao.incluir(item);
        return abrir();
    }
    
    public String voltarItensSolicitacao(){
        return abrirItensDeSolicitacao();
    }
    
    public String alterarItem(Item item) {
        return abrir();
    }
    
    public String abrirCompraDeItem(Item item) {
        return "CompraDeItem";
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
    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(SolicitacaoDao solicitacaoDao) {
        this.solicitacaoDao = solicitacaoDao;
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
