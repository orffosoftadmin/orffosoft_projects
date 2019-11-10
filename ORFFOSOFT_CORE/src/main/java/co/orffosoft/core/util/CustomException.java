package co.orffosoft.core.util;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import co.orffosoft.core.util.Util;
import lombok.extern.log4j.Log4j2;

@ManagedBean(name = "customException")
@SessionScoped
@Log4j2
public class CustomException extends Exception  {

	private static final long serialVersionUID = -6771150030530080923L;
	public CustomException(){
		super();
	}
	
	public CustomException(Exception e) {
		
		if(e instanceof ResourceAccessException){
			Util.addWarn("Service is not available");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			log.error("ResourceAccessException: connection error",e);			
			forwardErrorPage();
		}else if(e instanceof HttpClientErrorException){
			Util.addWarn("Service is not available");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			log.error("HttpClientErrorException: unauthorized", e);
			forwardErrorPage();
		}else if(e instanceof HttpServerErrorException){
			Util.addWarn("Service is not available");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			log.error("HttpServerErrorException: Service is not available", e);
			forwardErrorPage();
		}else{
			Util.addWarn("Service is not available");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			log.error("inside General error ", e);
		}
		
	}
	
	public void forwardErrorPage() {
		log.error("Error page called:");
		try {
			 ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
			 extCon.redirect(extCon.getRequestContextPath()
			        + "/pages/error.xhtml");			
		} catch (IOException e) {
			log.error("error occured:");
			e.printStackTrace();
			
		}		
	}
	
}

