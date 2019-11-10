/**
 * 
 */
package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "product_variety_master")
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@ToString(exclude = "productGroupMaster")
public class ProductVarietyMaster extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6850646178784761284L;

	@Id
	@SequenceGenerator(name = "product_variety_master_id_seq", sequenceName = "product_variety_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_variety_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "code", columnDefinition = "varchar(30)", nullable = false)
	private String code;

	@Column(name = "name", columnDefinition = "varchar(250)", nullable = false)
	private String name;

	@Column(name = "description", columnDefinition = "varchar(250)", nullable = true)
	private String description;

	@Column(name = "l_name", columnDefinition = "varchar(250)", nullable = false)
	private String lname;

	@Column(name = "length_actual")
	private Double lengthActual;

	@Column(name = "length_tolerance")
	private Double lengthTolerance;

	@Column(name = "width_actual")
	private Double widthActual;

	@Column(name = "width_tolerance")
	private Double widthTolerance;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "warp_yarn_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PRODUCT_VARIETY_MASTER_WARPYARNTYPEID"))
//	private YarnTypeMaster warpyarnTypeMaster;

	@Column(name = "warp_yarn_weight")
	private Double warpYarnWeight;
	
	@Column(name = "warp_yarn_count_actual")
	private String warpYarnCountActual;

	@Column(name = "warp_yarn_count_tolerance")
	private Double warpYarnCountTolerance;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "weft_yarn_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PRODUCT_VARIETY_MASTER_WEFTYARNTYPEID"))
//	private YarnTypeMaster weftyarnTypeMaster;

	@Column(name = "weft_yarn_weight")
	private Double weftYarnWeight;

	@Column(name = "weft_yarn_count_actual")
	private String weftYarnCountActual;

	@Column(name = "weft_yarn_count_tolerance")
	private Double weftYarnCountTolerance;

	@Column(name = "picks_per_inch_actual")
	private Double picksPerInchActual;

	@Column(name = "picks_per_inch_tolerance")
	private Double picksPerInchTolerance;

	@Column(name = "ends_per_inch_actual")
	private Double endspPerInchActual;

	@Column(name = "ends_per_inch_tolerance")
	private Double endsPerInchTolerance;

	@Column(name = "hsn_code")
	private String hsnCode;

	@Column(name = "costing_type")
	private String costingType;

	@Column(name = "active_status", nullable = false, columnDefinition = "boolean default '1'")
	private Boolean activeStatus;

	@Column(name = "selectable", nullable = false, columnDefinition = "boolean default '1'")
	private Boolean selectable;

	@Version
	@Column(name = "version")
	private Long version;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "uom_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_productvrtymstr_uomid"))
	private UomMaster uomMaster;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "luom_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_productvrtymstr_luomid"))
	private UomMaster lengthUomMaster;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "wuom_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_productvrtymstr_wuomid"))
	private UomMaster widthUomMaster;

	/*
	 * @Column(name = "server_id") private Long serverId;
	 */

	@Column(name = "qr_code")
	private String qrCode;

	@Column(name = "large_image_path")
	private String largeImagePath;

	@Column(name = "medium_image_path")
	private String mediumImagePath;

	@Column(name = "small_image_path")
	private String smallImagePath;

	@Column(name = "thumbnail_image_path")
	private String thumbnailImagePath;

	@Column(name = "bulkorder_allowed")
	private Boolean bulkorderAllowed;
	
	@Column(name ="user_id")
	private Long userId;

	public ProductVarietyMaster() {
	}

	public ProductVarietyMaster(Long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	@Column(name = "cgst_percentage")
	private Long cgst_percentage;
	
	@Column(name = "sgst_percentage")
	private Long sgst_percentage;


}
