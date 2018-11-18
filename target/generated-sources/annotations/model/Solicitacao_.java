package model;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.FormaDePagamentos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T19:21:39")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ { 

    public static volatile SingularAttribute<Solicitacao, Double> preco;
    public static volatile SingularAttribute<Solicitacao, List> itens;
    public static volatile SingularAttribute<Solicitacao, Long> id;
    public static volatile SingularAttribute<Solicitacao, FormaDePagamentos> formaDePagamento;

}