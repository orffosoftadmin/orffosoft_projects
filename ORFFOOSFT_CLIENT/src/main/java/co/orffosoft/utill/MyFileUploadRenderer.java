package co.orffosoft.utill;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.fileupload.FileUploadRenderer;

public class MyFileUploadRenderer extends FileUploadRenderer {
	
	  @Override
	    public void decode(FacesContext context, UIComponent component) {
	        if (context.getExternalContext().getRequestContentType().toLowerCase().startsWith("multipart/")) {
	            super.decode(context, component);
	        }
	    }

}
