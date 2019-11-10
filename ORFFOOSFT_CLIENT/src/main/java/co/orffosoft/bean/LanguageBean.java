package co.orffosoft.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Scope("session")
public class LanguageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String localeCode = "en_IN";

	@Getter@Setter
	private String languageCss="lang-english";

	private static Map<String,Object> countries;
	static{
		Locale engLoc = new Locale("en", "IN");
		Locale tamLoc = new Locale("ta", "IN");
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", engLoc); //label, value
		//countries.put("\u0BA4\u0BAE\u0BBF\u0BB4\u0BCD", tamLoc);
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

		//value change event listener
		public void countryLocaleCodeChanged(ValueChangeEvent e){

			String newLocaleValue = e.getNewValue().toString();
			log.info("newLocaleValue ===> "+newLocaleValue);

			if(newLocaleValue.equals("ta_IN")){
				log.info("tamil font selected...");
				languageCss="lang-tamil";
			}else{
				log.info("english font selected...");
				languageCss="lang-english";
			}

			//loop country map to compare the locale code
			for (Map.Entry<String, Object> entry : countries.entrySet()) {

				if(entry.getValue().toString().equals(newLocaleValue)){
					FacesContext.getCurrentInstance()
					.getViewRoot().setLocale((Locale)entry.getValue());

				}
			}
		}

}
