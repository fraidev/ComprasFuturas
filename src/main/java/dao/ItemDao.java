/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Item;
import model.StatusItem;

/**
 *
 * @author Felipe Cardozo
 */
@Stateless
public class ItemDao {
    @PersistenceContext
    EntityManager em;
    
    public void incluir (Item item){
        em.persist(item);
    }
    public void alterar (Item item){
        em.merge(item);
    }
    public void excluir (Item item){
        em.remove(em.merge(item));
    }
    public List<Item> getItens (){
        Query q = em.createQuery("select i from Item i order by i.id");
        return q.getResultList();
    }
    public List<Item> getItensAberto (){
        Query q = em.createQuery("select i from Item i WHERE i.statusItem = :espera order by i.id", Item.class).setParameter("espera", StatusItem.Espera);
        return q.getResultList();
    }
    public List<Item> getItensComprado (){
        Query q = em.createQuery("select i from Item i WHERE i.statusItem = :comprado order by i.id", Item.class).setParameter("comprado", StatusItem.Comprado);
        return q.getResultList();
    }
    public List<Item> getItensMelhoresPrecosAberto (Long id){
        Query q = em.createQuery("select i from Item i WHERE i.solicitacao.id = :id order by i.precoUnitario").setParameter("id",id)
        .setMaxResults(3);
        return q.getResultList();
    }
    public List<Item> getItensByIdSolicitacao (Long id){
        Query q = em.createQuery("select i from Item i WHERE i.solicitacao.id = :id").setParameter("id",id);
        return q.getResultList();
    }
}
