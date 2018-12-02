package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.FormaDePagamento;
import model.Produto;
import model.Solicitacao;
import model.StatusItem;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-02T14:22:35")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Double> precoUnitario;
    public static volatile SingularAttribute<Item, Solicitacao> solicitacao;
    public static volatile SingularAttribute<Item, Produto> produto;
    public static volatile SingularAttribute<Item, StatusItem> statusItem;
    public static volatile SingularAttribute<Item, Date> dataDaCompra;
    public static volatile SingularAttribute<Item, String> localDaCompra;
    public static volatile SingularAttribute<Item, Long> id;
    public static volatile SingularAttribute<Item, FormaDePagamento> formaDePagamento;
    public static volatile SingularAttribute<Item, Integer> quantidade;

}