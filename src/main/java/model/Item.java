/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Felipe Cardozo
 */
public class Item {
    public Produto produto;
    public int quantidade;
    
    
    private FormaDePagamento formaDePagamento;
    private LocalDateTime  dataDaCompra;
    private String localDaCompra;
    
    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    public LocalDateTime getDataDaCompra(){
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDateTime dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }
    
    public String getLocalDaCompra(){
        return localDaCompra;
    }

    public void setLocalDaCompra(String localDaCompra) {
        this.localDaCompra = localDaCompra;
    }
}
