/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Item;

/**
 *
 * @author Felipe Cardozo
 */
@Named(value = "guiRelatorioGeral")
@SessionScoped
public class GuiRelatorioGeral  implements Serializable{
    @EJB
    ItemDao itemDao;
    private List<Item> itens;

    /**
     * Creates a new instance of GuiRelatorioGeral
     */
    public GuiRelatorioGeral() {
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public String voltar(){
        return "Dashboard";
    }
    
    public String abrir(){
        itens = itemDao.getItensComprado();
        return "RelatorioLstGeral";
    }
    
    public Double valorTotal(){
        Double valorTotal = 0.0;
        for(Item item: itemDao.getItensComprado()){
            valorTotal += item.getPrecoTotal();
        }
        return valorTotal;
    }
}
