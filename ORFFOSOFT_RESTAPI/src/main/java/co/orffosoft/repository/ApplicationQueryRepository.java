package co.orffosoft.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import co.orffosoft.entity.ApplicationQuery;
import lombok.extern.log4j.Log4j2;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Log4j2
public class ApplicationQueryRepository {

	@Autowired
	AppQueryRepository appQueryRepository;
	
	private Map<String, ApplicationQuery> applicationQueryMap = new HashMap<String, ApplicationQuery>();
	
	public ApplicationQuery findByQueryName(String queryName) {
		
		ApplicationQuery applicationQuery = null;
		
		if(applicationQueryMap.containsKey(queryName)) {
			applicationQuery = applicationQueryMap.get(queryName);
			log.info("Query taken from map.");
		} else {
			applicationQuery = appQueryRepository.findByQueryName(queryName);
			applicationQueryMap.put(queryName, applicationQuery);
			log.info("Query taken from database.");
		}
		
		return applicationQuery;
	}
	
	public ApplicationQuery findByQuery(String queryName) {
		return this.findByQueryName(queryName);
	}
}
