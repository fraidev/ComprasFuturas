/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProdutoDao;
import dao.SolicitacaoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Produto;
import model.Solicitacao;

/**
 *
 * @author Felipe Cardozo
 */
@Named(value = "guiProduto")
@SessionScoped
public class GuiProduto implements Serializable {
    @EJB
    ProdutoDao produtoDao;
    
    private List<Produto> produtos;
    private Produto produto;
    private Boolean alterando = false;

    /**
     * Creates a new instance of GuiComprasFuturas
     */
    public GuiProduto() {
    }
    
    public String abrir() {
        produtos = produtoDao.getProdutos();
        return "LstProdutos";
    }
    
    public String incluir() {
        this.produto = new Produto();
        alterando = true;
        return "CadProduto";
    }

    public String alterar(Produto produto) {
        this.produto = produto;
        alterando = true;
        return "CadProduto";
    }
    
    public String excluir(Produto produto) {
        produtoDao.excluir(produto);
        return abrir();
    }
    
    public String gravar() {
        if (alterando) {
            produtoDao.alterar(produto);
        } else {
            produtoDao.incluir(produto);
        }
        return abrir();
    }
    
    public String voltar(){
        return abrir();
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public List<Produto> getSolicitacoes() {
        return produtos;
    }
    
    public void setSolicitacoes(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setSolicitacao(Produto produto) {
        this.produto = produto;
    }
}
