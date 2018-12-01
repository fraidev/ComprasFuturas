/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Felipe Cardozo
 */
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String descricao;
    public TipoMedidas medida;
    public Double valorDaMedida;
    
    public Produto(){
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public TipoMedidas getMedida() {
        return medida;
    }

    public void setMedida(TipoMedidas medida) {
        this.medida = medida;
    }
    
    public Double getValorDaMedida(){
        return valorDaMedida;
    }

    public void setValorDaMedida(Double valorDaMedida) {
        this.valorDaMedida = valorDaMedida;
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.descricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.medida, other.medida)) {
            return false;
        }
        if (!Objects.equals(this.valorDaMedida, other.valorDaMedida)) {
            return false;
        }
        return true;
    }

    public String getChave() {
        String med = medida.toString();
        String valmed = valorDaMedida.toString();
        String ident = Long.toString(id);
        return ident + ";" + nome + ";" + descricao + ";" + med + ";" + valmed;
    }
    public void setChave(String chave) {
        String campo[] = chave.split(";");
        id = Long.parseLong(campo[0]);
        nome = campo[1];
        descricao = campo[2];
        medida = TipoMedidas.valueOf(campo[3]);
        valorDaMedida = Double.parseDouble(campo[4]);
    }
}
