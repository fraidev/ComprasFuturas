/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Item;

/**
 *
 * @author Felipe Cardozo
 */
@Named(value = "guiRelatorioCompras")
@SessionScoped
public class GuiRelatorioCompras implements Serializable {
    @EJB
    ItemDao itemDao;
    private List<Item> itens;
    private List<Item> itensMelhores;

    /**
     * Creates a new instance of GuiRelatorioCompras
     */
    public GuiRelatorioCompras() {
    }
    
    
    public List<Item> getItens() {
        return itens;
    }
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public List<Item> getItensMelhores() {
        return itensMelhores;
    }
    
    public void setItensMelhores(List<Item> itensMelhores) {
        this.itensMelhores = itensMelhores;
    }
    
    public String voltar(){
        return "Dashboard";
    }
    
    public String abrir(){
        itens = itemDao.getItensAberto();
        return "RelatorioLstCompra";
    }
    
    public String abrirMelhoresPrecos(Item item) {
        itensMelhores = itemDao.getItensMelhoresPrecosAberto(item.getProduto().getId());
        return "MelhoresPrecos";
    }
}
