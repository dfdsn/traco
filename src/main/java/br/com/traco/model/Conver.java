package br.com.traco.model;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.traco.controller.PedidoBean;


@FacesConverter(value = "pedidoConverter")
public class Conver implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String objId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{pedidoBean}", PedidoBean.class);

        PedidoBean pedidoBean = (PedidoBean)vex.getValue(ctx.getELContext());
        for(Pedido pedi : pedidoBean.getPedidos()){
        	if (!objId.equalsIgnoreCase("Selecione o pedido") && !objId.equalsIgnoreCase("Todos") && new Long(objId).equals(pedi.getId())){
                return pedi;
            }
        }
        return null; //projetoBean.getProjeto(Long.valueOf(objId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
    	if(obj != null && obj instanceof Pedido){
    		return ((Pedido)obj).getId().toString();
    	}
        return null;
    }

	
}
