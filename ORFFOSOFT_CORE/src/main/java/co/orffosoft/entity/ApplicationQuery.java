package co.orffosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "application_queries", uniqueConstraints = {
		@UniqueConstraint(name ="uq_application_queries_queryname", columnNames="query_name")
})
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationQuery {
	
	@Id
	@SequenceGenerator(name = "application_queries_id_seq", sequenceName = "application_queries_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_queries_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(name = "query_name")
	private String queryName;
	
	@Column(name = "query_content")
	private String queryContent;
	
	@Column(name = "description")
	private String description;
	

	@Column(name = "created_date")
	private String createdDate;
	
	@Version
	@Column(name = "version")
	private Long version;
}
