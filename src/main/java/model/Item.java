/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe Cardozo
 */
@Entity
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    private int quantidade;
    @OneToOne
    private Produto produto;
    @ManyToOne
    private Solicitacao solicitacao;
    private FormaDePagamento formaDePagamento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  dataDaCompra;
    private String localDaCompra;
    private String precoUnitario;
    private StatusItem statusItem;
    
    public Item() {
    }
    
    public Item(Solicitacao solicitacao) {
        this.statusItem = StatusItem.Espera;
        this.solicitacao = solicitacao;
//        this.formaDePagamento = FormaDePagamento.cartao;
//        this.dataDaCompra = LocalDateTime.now();
    }
    
    public Item(Solicitacao solicitacao, Produto produto) {
        this.statusItem = StatusItem.Espera;
        this.solicitacao = solicitacao;
        this.produto = produto;
        this.formaDePagamento = FormaDePagamento.cartao;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    public Date getDataDaCompra(){
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }
    
    public String getLocalDaCompra(){
        return localDaCompra;
    }

    public void setLocalDaCompra(String localDaCompra) {
        this.localDaCompra = localDaCompra;
    }
    
    public String getPrecoUnitario(){
        return precoUnitario;
    }

    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    public StatusItem getStatusItem(){
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "model.Item[ id=" + id + " ]";
    }

}
