/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Produto;

/**
 *
 * @author Felipe Cardozo
 */
@FacesConverter(forClass = Produto.class)
public class ConverterProduto implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String chave) {
        if (chave != null && !chave.isEmpty()) {
            Produto produto = new Produto();
            produto.setChave(chave);
            return produto;    
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if ((value != null) && (value instanceof Produto)) {
            Produto produto = (Produto) value;
            return produto.getChave();
        }
	return "";
    }
}
