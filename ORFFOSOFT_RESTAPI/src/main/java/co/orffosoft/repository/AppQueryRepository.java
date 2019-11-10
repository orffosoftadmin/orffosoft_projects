package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.orffosoft.entity.ApplicationQuery;

/**
 * @author Pratap Kumar Sahu
 *
 */
public interface AppQueryRepository extends JpaRepository<ApplicationQuery, Long> {

	@Query("FROM ApplicationQuery aq WHERE aq.queryName = ?1")
	ApplicationQuery findByQueryName(String queryName);
	@Query("FROM ApplicationQuery aq WHERE aq.queryName = ?1")
	ApplicationQuery findByQuery(String query);

}
