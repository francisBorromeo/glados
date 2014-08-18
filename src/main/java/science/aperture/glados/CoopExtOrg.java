/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_ext_org")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopExtOrg.findAll", query = "SELECT c FROM CoopExtOrg c"),
	@NamedQuery(name = "CoopExtOrg.findByExtOrgName", query = "SELECT c FROM CoopExtOrg c WHERE c.extOrgName = :extOrgName"),
	@NamedQuery(name = "CoopExtOrg.findByExtOrgNature", query = "SELECT c FROM CoopExtOrg c WHERE c.extOrgNature = :extOrgNature"),
	@NamedQuery(name = "CoopExtOrg.findByStreet", query = "SELECT c FROM CoopExtOrg c WHERE c.street = :street"),
	@NamedQuery(name = "CoopExtOrg.findByBarangay", query = "SELECT c FROM CoopExtOrg c WHERE c.barangay = :barangay"),
	@NamedQuery(name = "CoopExtOrg.findByCityMun", query = "SELECT c FROM CoopExtOrg c WHERE c.cityMun = :cityMun"),
	@NamedQuery(name = "CoopExtOrg.findByRegion", query = "SELECT c FROM CoopExtOrg c WHERE c.region = :region"),
	@NamedQuery(name = "CoopExtOrg.findByProvince", query = "SELECT c FROM CoopExtOrg c WHERE c.province = :province"),
	@NamedQuery(name = "CoopExtOrg.findByExtOrgNo", query = "SELECT c FROM CoopExtOrg c WHERE c.extOrgNo = :extOrgNo"),
	@NamedQuery(name = "CoopExtOrg.findByExtOrgCode", query = "SELECT c FROM CoopExtOrg c WHERE c.extOrgCode = :extOrgCode")})
public class CoopExtOrg implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ext_org_name")
	private String extOrgName;
	@Size(max = 40)
    @Column(name = "ext_org_nature")
	private String extOrgNature;
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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ext_org_no")
	private Integer extOrgNo;
	@Size(max = 4)
    @Column(name = "ext_org_code")
	private String extOrgCode;
	@OneToMany(mappedBy = "extOrgNo")
	private Collection<CoopExtOrgAct> coopExtOrgActCollection;
	@OneToMany(mappedBy = "extOrgNo")
	private Collection<CoopPersExtOrg> coopPersExtOrgCollection;

	public CoopExtOrg() {
	}

	public CoopExtOrg(Integer extOrgNo) {
		this.extOrgNo = extOrgNo;
	}

	public CoopExtOrg(Integer extOrgNo, String extOrgName) {
		this.extOrgNo = extOrgNo;
		this.extOrgName = extOrgName;
	}

	public String getExtOrgName() {
		return extOrgName;
	}

	public void setExtOrgName(String extOrgName) {
		this.extOrgName = extOrgName;
	}

	public String getExtOrgNature() {
		return extOrgNature;
	}

	public void setExtOrgNature(String extOrgNature) {
		this.extOrgNature = extOrgNature;
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

	public Integer getExtOrgNo() {
		return extOrgNo;
	}

	public void setExtOrgNo(Integer extOrgNo) {
		this.extOrgNo = extOrgNo;
	}

	public String getExtOrgCode() {
		return extOrgCode;
	}

	public void setExtOrgCode(String extOrgCode) {
		this.extOrgCode = extOrgCode;
	}

	@XmlTransient
	public Collection<CoopExtOrgAct> getCoopExtOrgActCollection() {
		return coopExtOrgActCollection;
	}

	public void setCoopExtOrgActCollection(Collection<CoopExtOrgAct> coopExtOrgActCollection) {
		this.coopExtOrgActCollection = coopExtOrgActCollection;
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
		hash += (extOrgNo != null ? extOrgNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopExtOrg)) {
			return false;
		}
		CoopExtOrg other = (CoopExtOrg) object;
		if ((this.extOrgNo == null && other.extOrgNo != null) || (this.extOrgNo != null && !this.extOrgNo.equals(other.extOrgNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopExtOrg[ extOrgNo=" + extOrgNo + " ]";
	}
	
}
