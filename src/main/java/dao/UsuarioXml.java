/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Felipe Cardozo
 */
public class UsuarioXml {
    public static List<Usuario> usuarios = new ArrayList();
    private static final String nomeArquivo = "usuarios.xml";
    
    public void gravar(Usuario usuario) throws Exception {
        usuarios.add(usuario);
        Xml.gravaXml(nomeArquivo, usuarios);
    }
    
    public void excluir(Usuario usuario) throws Exception {
        usuarios.remove(usuario);
        Xml.gravaXml(nomeArquivo, usuarios);        
    }

    public void alterar(Usuario usuario) throws Exception {
        Xml.gravaXml(nomeArquivo, usuarios);
    }
    
    public List<Usuario> getLista() {
        try {
            usuarios = (List<Usuario>) Xml.leXml(nomeArquivo);
        } catch (Exception ex) {
            Logger.getLogger("Teste").log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
