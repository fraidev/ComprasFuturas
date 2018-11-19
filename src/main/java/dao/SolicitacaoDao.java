/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Solicitacao;

/**
 *
 * @author Felipe Cardozo
 */
@Stateless
public class SolicitacaoDao {
    
    @PersistenceContext
    EntityManager em;
    
    public void incluir (Solicitacao solicitacao){
        em.persist(solicitacao);
    }
    public void alterar (Solicitacao solicitacao){
        em.merge(solicitacao);
    }
    public void excluir (Solicitacao solicitacao){
        em.remove(em.merge(solicitacao));
    }
    
    public List<Solicitacao> getSolicitacoes (String usuarioNome){
        Query q = em.createQuery("select s from  Solicitacao s order by s.id");
        List<Solicitacao> solicitacoes = q.getResultList();
        List<Solicitacao> solicitacoesResultado = new ArrayList<>();
        for(Solicitacao s: solicitacoes){
            String retval = s.getUsuarioNome();
            if(usuarioNome.equals(retval)){
                solicitacoesResultado.add(s);
            }
        }
        return solicitacoesResultado;
    }
}
