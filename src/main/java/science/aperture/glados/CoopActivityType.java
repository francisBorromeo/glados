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
@Table(name = "coop_activity_type")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopActivityType.findAll", query = "SELECT c FROM CoopActivityType c"),
	@NamedQuery(name = "CoopActivityType.findByActTypeCode", query = "SELECT c FROM CoopActivityType c WHERE c.actTypeCode = :actTypeCode"),
	@NamedQuery(name = "CoopActivityType.findByActType", query = "SELECT c FROM CoopActivityType c WHERE c.actType = :actType"),
	@NamedQuery(name = "CoopActivityType.findByActDesc", query = "SELECT c FROM CoopActivityType c WHERE c.actDesc = :actDesc")})
public class CoopActivityType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_type_code")
	private Integer actTypeCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "act_type")
	private String actType;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "act_desc")
	private String actDesc;
	@OneToMany(mappedBy = "actTypeCode")
	private Collection<CoopAppSched> coopAppSchedCollection;
	@OneToMany(mappedBy = "actTypeCode")
	private Collection<CoopActivity> coopActivityCollection;

	public CoopActivityType() {
	}

	public CoopActivityType(Integer actTypeCode) {
		this.actTypeCode = actTypeCode;
	}

	public CoopActivityType(Integer actTypeCode, String actType, String actDesc) {
		this.actTypeCode = actTypeCode;
		this.actType = actType;
		this.actDesc = actDesc;
	}

	public Integer getActTypeCode() {
		return actTypeCode;
	}

	public void setActTypeCode(Integer actTypeCode) {
		this.actTypeCode = actTypeCode;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getActDesc() {
		return actDesc;
	}

	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}

	@XmlTransient
	public Collection<CoopAppSched> getCoopAppSchedCollection() {
		return coopAppSchedCollection;
	}

	public void setCoopAppSchedCollection(Collection<CoopAppSched> coopAppSchedCollection) {
		this.coopAppSchedCollection = coopAppSchedCollection;
	}

	@XmlTransient
	public Collection<CoopActivity> getCoopActivityCollection() {
		return coopActivityCollection;
	}

	public void setCoopActivityCollection(Collection<CoopActivity> coopActivityCollection) {
		this.coopActivityCollection = coopActivityCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (actTypeCode != null ? actTypeCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopActivityType)) {
			return false;
		}
		CoopActivityType other = (CoopActivityType) object;
		if ((this.actTypeCode == null && other.actTypeCode != null) || (this.actTypeCode != null && !this.actTypeCode.equals(other.actTypeCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopActivityType[ actTypeCode=" + actTypeCode + " ]";
	}
	
}
