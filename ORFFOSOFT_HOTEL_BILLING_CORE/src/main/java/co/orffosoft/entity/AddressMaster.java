package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address_master", indexes = {
		@Index(name = "IDX_ADDRESS_MASTER_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_ADDRESS_MASTER_MODIFIEDDATE", columnList = "modified_date") })
// @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
/**/
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "FK_ADDRESS_MASTER_CREATEDBY")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "FK_ADDRESS_MASTER_MODIFIEDBY")) })
@Getter
@Setter
@ToString
public class AddressMaster extends Trackable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "address_master_id_seq", sequenceName = "address_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "sync_code")
	private Long syncCode;

	@Column(name = "name")
	private String name;

	@Column(name = "line_one")
	private String addressLineOne;

	@Column(name = "l_line_one")
	private String locAddressLineOne;

	@Column(name = "line_two")
	private String addressLineTwo;

	@Column(name = "l_line_two")
	private String locAddressLineTwo;

	@Column(name = "line_three")
	private String addressLineThree;

	@Column(name = "l_line_three")
	private String locAddressLineThree;

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "country_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "FK_ADDRESS_MASTER_COUNTRYID"))
//	private CountryMaster countryMaster;
//
//	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
//	@JoinColumn(name = "state_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "FK_ADDRESS_MASTER_STATEID"))
//	private StateMaster stateMaster;
//
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "district_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "FK_ADDRESS_MASTER_DISTRICTID"))
//	private DistrictMaster districtMaster;
//
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "city_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "FK_ADDRESS_MASTER_CITYID"))
//	private CityMaster cityMaster;


	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "land_mark")
	private String landmark;

	@Column(name = "geo_coordinates")
	private String geoCoordinates;

	@Version
	@Column(name = "version")
	private Long version;

}
