package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "application", indexes = { @Index(name = "IDX_APPLICATION_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_APPLICATION_MODIFIEDDATE", columnList = "modified_date") }, uniqueConstraints = @UniqueConstraint(columnNames = {
				"application_name" }, name = "UK_APPLICATION_NAME") )
@EqualsAndHashCode(callSuper = false)
public class Application extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "application_id_seq", sequenceName = "application_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "application_name")
	String applicationName;

	@Version
	@Column(name = "version")
	private Long version;

}
