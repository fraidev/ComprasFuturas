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
public class Usuario implements Serializable {
    private String nomeDeUsuario;
    private String senha;    
    
    public Usuario(){
        
    }
    
    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }  
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
