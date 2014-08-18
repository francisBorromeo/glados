/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_personality")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopPersonality.findAll", query = "SELECT c FROM CoopPersonality c"),
	@NamedQuery(name = "CoopPersonality.findByPersIdNo", query = "SELECT c FROM CoopPersonality c WHERE c.persIdNo = :persIdNo"),
	@NamedQuery(name = "CoopPersonality.findByLastName", query = "SELECT c FROM CoopPersonality c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "CoopPersonality.findByFirstName", query = "SELECT c FROM CoopPersonality c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "CoopPersonality.findByMiddleName", query = "SELECT c FROM CoopPersonality c WHERE c.middleName = :middleName"),
	@NamedQuery(name = "CoopPersonality.findByNickname", query = "SELECT c FROM CoopPersonality c WHERE c.nickname = :nickname"),
	@NamedQuery(name = "CoopPersonality.findByGender", query = "SELECT c FROM CoopPersonality c WHERE c.gender = :gender"),
	@NamedQuery(name = "CoopPersonality.findByBirthdate", query = "SELECT c FROM CoopPersonality c WHERE c.birthdate = :birthdate"),
	@NamedQuery(name = "CoopPersonality.findByBirthplace", query = "SELECT c FROM CoopPersonality c WHERE c.birthplace = :birthplace"),
	@NamedQuery(name = "CoopPersonality.findByStreet", query = "SELECT c FROM CoopPersonality c WHERE c.street = :street"),
	@NamedQuery(name = "CoopPersonality.findByBarangay", query = "SELECT c FROM CoopPersonality c WHERE c.barangay = :barangay"),
	@NamedQuery(name = "CoopPersonality.findByCityMun", query = "SELECT c FROM CoopPersonality c WHERE c.cityMun = :cityMun"),
	@NamedQuery(name = "CoopPersonality.findByRegion", query = "SELECT c FROM CoopPersonality c WHERE c.region = :region"),
	@NamedQuery(name = "CoopPersonality.findByProvince", query = "SELECT c FROM CoopPersonality c WHERE c.province = :province"),
	@NamedQuery(name = "CoopPersonality.findByZipCode", query = "SELECT c FROM CoopPersonality c WHERE c.zipCode = :zipCode"),
	@NamedQuery(name = "CoopPersonality.findByCivilStatus", query = "SELECT c FROM CoopPersonality c WHERE c.civilStatus = :civilStatus"),
	@NamedQuery(name = "CoopPersonality.findByContactNumber", query = "SELECT c FROM CoopPersonality c WHERE c.contactNumber = :contactNumber"),
	@NamedQuery(name = "CoopPersonality.findByEmail", query = "SELECT c FROM CoopPersonality c WHERE c.email = :email"),
	@NamedQuery(name = "CoopPersonality.findByNationality", query = "SELECT c FROM CoopPersonality c WHERE c.nationality = :nationality"),
	@NamedQuery(name = "CoopPersonality.findByOccupation", query = "SELECT c FROM CoopPersonality c WHERE c.occupation = :occupation"),
	@NamedQuery(name = "CoopPersonality.findByReligion", query = "SELECT c FROM CoopPersonality c WHERE c.religion = :religion"),
	@NamedQuery(name = "CoopPersonality.findByPPrefix", query = "SELECT c FROM CoopPersonality c WHERE c.pPrefix = :pPrefix"),
	@NamedQuery(name = "CoopPersonality.findBySuffix", query = "SELECT c FROM CoopPersonality c WHERE c.suffix = :suffix"),
	@NamedQuery(name = "CoopPersonality.findByPersonStatus", query = "SELECT c FROM CoopPersonality c WHERE c.personStatus = :personStatus")})
public class CoopPersonality implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_id_no")
	private Integer persIdNo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
	private String lastName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
	private String firstName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "middle_name")
	private String middleName;
	@Size(max = 15)
    @Column(name = "nickname")
	private String nickname;
	@Basic(optional = false)
    @NotNull
    @Column(name = "gender")
	private Character gender;
	@Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
	private Date birthdate;
	@Size(max = 20)
    @Column(name = "birthplace")
	private String birthplace;
	@Size(max = 60)
    @Column(name = "street")
	private String street;
	@Size(max = 50)
    @Column(name = "barangay")
	private String barangay;
	@Size(max = 50)
    @Column(name = "city_mun")
	private String cityMun;
	@Size(max = 50)
    @Column(name = "region")
	private String region;
	@Size(max = 50)
    @Column(name = "province")
	private String province;
	@Size(max = 4)
    @Column(name = "zip_code")
	private String zipCode;
	@Column(name = "civil_status")
	private Character civilStatus;
	@Size(max = 12)
    @Column(name = "contact_number")
	private String contactNumber;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Size(max = 30)
    @Column(name = "email")
	private String email;
	@Size(max = 8)
    @Column(name = "nationality")
	private String nationality;
	@Size(max = 20)
    @Column(name = "occupation")
	private String occupation;
	@Size(max = 14)
    @Column(name = "religion")
	private String religion;
	@Size(max = 8)
    @Column(name = "p_prefix")
	private String pPrefix;
	@Size(max = 5)
    @Column(name = "suffix")
	private String suffix;
	@Column(name = "person_status")
	private Boolean personStatus;
	@OneToMany(mappedBy = "persIdNo")
	private Collection<CoopPersAct> coopPersActCollection;
	@JoinColumn(name = "pers_sec_code", referencedColumnName = "pers_sec_code")
    @ManyToOne
	private CoopPersSector persSecCode;
	@OneToMany(mappedBy = "persIdNo")
	private Collection<CoopPersExtOrg> coopPersExtOrgCollection;

	public CoopPersonality() {
	}

	public CoopPersonality(Integer persIdNo) {
		this.persIdNo = persIdNo;
	}

	public CoopPersonality(Integer persIdNo, String lastName, String firstName, String middleName, Character gender) {
		this.persIdNo = persIdNo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.gender = gender;
	}

	public Integer getPersIdNo() {
		return persIdNo;
	}

	public void setPersIdNo(Integer persIdNo) {
		this.persIdNo = persIdNo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCityMun() {
		return cityMun;
	}

	public void setCityMun(String cityMun) {
		this.cityMun = cityMun;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Character getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(Character civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getPPrefix() {
		return pPrefix;
	}

	public void setPPrefix(String pPrefix) {
		this.pPrefix = pPrefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Boolean getPersonStatus() {
		return personStatus;
	}

	public void setPersonStatus(Boolean personStatus) {
		this.personStatus = personStatus;
	}

	@XmlTransient
	public Collection<CoopPersAct> getCoopPersActCollection() {
		return coopPersActCollection;
	}

	public void setCoopPersActCollection(Collection<CoopPersAct> coopPersActCollection) {
		this.coopPersActCollection = coopPersActCollection;
	}

	public CoopPersSector getPersSecCode() {
		return persSecCode;
	}

	public void setPersSecCode(CoopPersSector persSecCode) {
		this.persSecCode = persSecCode;
	}

	@XmlTransient
	public Collection<CoopPersExtOrg> getCoopPersExtOrgCollection() {
		return coopPersExtOrgCollection;
	}

	public void setCoopPersExtOrgCollection(Collection<CoopPersExtOrg> coopPersExtOrgCollection) {
		this.coopPersExtOrgCollection = coopPersExtOrgCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (persIdNo != null ? persIdNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopPersonality)) {
			return false;
		}
		CoopPersonality other = (CoopPersonality) object;
		if ((this.persIdNo == null && other.persIdNo != null) || (this.persIdNo != null && !this.persIdNo.equals(other.persIdNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopPersonality[ persIdNo=" + persIdNo + " ]";
	}
	
}
