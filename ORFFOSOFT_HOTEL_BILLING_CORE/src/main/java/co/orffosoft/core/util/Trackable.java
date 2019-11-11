package co.orffosoft.core.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import co.orffosoft.entity.UserMaster;
import lombok.Getter;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class Trackable implements Serializable {

	private static final long serialVersionUID = 7808171504446687956L;

	@ManyToOne
	@JoinColumn(name = "created_by")
	@CreatedBy
	public UserMaster createdBy;

	@Column(name = "created_date", nullable = false)
	@CreatedDate
	public Date createdDate;

	@ManyToOne
	@JoinColumn(name = "modified_by")
	@LastModifiedBy
	public UserMaster modifiedBy;

	@Column(name = "modified_date", nullable = true)
	@LastModifiedDate
	public Date modifiedDate;

	/*
	 * Created By Name to display in View Page
	 * 
	 */
	@Transient
	public String createdByName;

	/* which no.th page Required */
	@Transient
	Integer first;

	/* the Size of the page required */
	@Transient
	Integer pagesize;

}
