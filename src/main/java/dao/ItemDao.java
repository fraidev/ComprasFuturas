/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Item;

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
}
