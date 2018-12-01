package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Item;
import model.Status;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T18:28:06")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ { 

    public static volatile SingularAttribute<Solicitacao, Double> preco;
    public static volatile ListAttribute<Solicitacao, Item> itens;
    public static volatile SingularAttribute<Solicitacao, Long> id;
    public static volatile SingularAttribute<Solicitacao, Status> status;

}