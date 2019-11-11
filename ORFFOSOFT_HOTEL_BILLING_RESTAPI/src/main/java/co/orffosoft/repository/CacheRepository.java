package co.orffosoft.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import co.orffosoft.entity.ErrorMaster;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CacheRepository {

	@Autowired
	ErrorMasterRepository errorMasterRepository;
//
//	@Autowired
//	TemplateDetailsRepository templateDetailsRepository;
	
	@SuppressWarnings("unchecked")
	@CachePut(value = "defaultCache", key = "#object.id +'-'+#uniqueKey", unless = "#result == null")
	public <T> T save(String uniqueKey, T object, @SuppressWarnings("rawtypes") JpaRepository objRepository) {
		if (object == null) {
			return null;
		}
		log.info("Data saved into Database : id[" + uniqueKey + "]");
		return (T) objRepository.save(object);
	}

	@SuppressWarnings("unchecked")
	@Cacheable(value = "defaultCache", key = "#id +'-'+#uniqueKey", unless = "#result==null")
	public <T> T get(String uniqueKey, Long id, @SuppressWarnings("rawtypes") JpaRepository objRepository) {
		T object = (T) objRepository.findOne(id);
		log.info("Data fetched from Database : id[" + "-" + uniqueKey + "-" + id + "]");
		return object;
	}

	@SuppressWarnings("unchecked")
	@Cacheable(value = "defaultCache", key = "#uniqueKey+'-list'", unless = "#result==null")
	public <T> List<T> getAll(String uniqueKey, @SuppressWarnings("rawtypes") JpaRepository objRepository, Sort sort) {
		List<T> list = objRepository.findAll(sort);
		log.info(uniqueKey + "List Data fetched from Database and the size is :" + list.size());
		return list;
	}

	@CacheEvict(value = "defaultCache", key = "#uniqueKey+'-list'", allEntries = true)
	public void removeList(String uniqueKey) {
		log.info(uniqueKey + " List data Removed from cache");
	}

	@CacheEvict(value = { "defaultCache" }, allEntries = true)
	public void clearCache() {
		// Clear all redis cache
		log.info("Clear all redis cache");
	}

	@CacheEvict(value = "defaultCache", key = "#id +'-'+#uniqueKey", allEntries = true)
	public void remove(String uniqueKey, Long id) {
		log.info("Removed from cache :" + uniqueKey + id);
	}

	@SuppressWarnings("unchecked")
	public void delete(String uniqueKey, Long id, @SuppressWarnings("rawtypes") JpaRepository objRepository) {
		objRepository.delete(id);
		remove(uniqueKey, id);
		log.info("deleting redis cache for id :" + id);

	}

	@SuppressWarnings("unchecked")
//	@Cacheable(value = "defaultCache", key = "#uniqueKey+'-error-list'", unless = "#result == null")
	public Map<String, ErrorMaster> loadErrorMaster(String uniqueKey) {
		Map<String, ErrorMaster> errorMap = new HashMap<>();
		try {
		List<ErrorMaster> errorMasterList = errorMasterRepository.findAll();
		for (ErrorMaster errorMaster : errorMasterList) {
			errorMap.put(errorMaster.getLanguageCode() + "_" + errorMaster.getCode(), errorMaster);
		}
		log.info("ErrorMaster Map loaded into the cache...");
		}catch (Exception e) {
			log.info("ErrorMaster Map loaded into the cache...",e);
		}
		return errorMap;
	}
	
//	@Cacheable(value = "defaultCache", key = "#id +'-'+#templateCode", unless = "#result==null")
//	public TemplateDetails getTemplateByTemplateCode(TemplateCode templateCode) {
//		TemplateDetails templateDetails = templateDetailsRepository.findByTemplateCode(templateCode);
//		log.info("Data fetched from Database : Template Code [" + templateCode + "]");
//		return templateDetails;
//	}
}
