package model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.FormaDePagamento;
import model.Produto;
import model.Solicitacao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T18:28:06")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Solicitacao> solicitacao;
    public static volatile SingularAttribute<Item, Produto> produto;
    public static volatile SingularAttribute<Item, LocalDateTime> dataDaCompra;
    public static volatile SingularAttribute<Item, String> localDaCompra;
    public static volatile SingularAttribute<Item, Long> id;
    public static volatile SingularAttribute<Item, FormaDePagamento> formaDePagamento;
    public static volatile SingularAttribute<Item, Integer> quantidade;

}