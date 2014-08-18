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
@Table(name = "coop_pers_sector")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopPersSector.findAll", query = "SELECT c FROM CoopPersSector c"),
	@NamedQuery(name = "CoopPersSector.findByPersSecCode", query = "SELECT c FROM CoopPersSector c WHERE c.persSecCode = :persSecCode"),
	@NamedQuery(name = "CoopPersSector.findByPersSecName", query = "SELECT c FROM CoopPersSector c WHERE c.persSecName = :persSecName")})
public class CoopPersSector implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_sec_code")
	private Integer persSecCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pers_sec_name")
	private String persSecName;
	@OneToMany(mappedBy = "persSecCode")
	private Collection<CoopPersonality> coopPersonalityCollection;

	public CoopPersSector() {
	}

	public CoopPersSector(Integer persSecCode) {
		this.persSecCode = persSecCode;
	}

	public CoopPersSector(Integer persSecCode, String persSecName) {
		this.persSecCode = persSecCode;
		this.persSecName = persSecName;
	}

	public Integer getPersSecCode() {
		return persSecCode;
	}

	public void setPersSecCode(Integer persSecCode) {
		this.persSecCode = persSecCode;
	}

	public String getPersSecName() {
		return persSecName;
	}

	public void setPersSecName(String persSecName) {
		this.persSecName = persSecName;
	}

	@XmlTransient
	public Collection<CoopPersonality> getCoopPersonalityCollection() {
		return coopPersonalityCollection;
	}

	public void setCoopPersonalityCollection(Collection<CoopPersonality> coopPersonalityCollection) {
		this.coopPersonalityCollection = coopPersonalityCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (persSecCode != null ? persSecCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopPersSector)) {
			return false;
		}
		CoopPersSector other = (CoopPersSector) object;
		if ((this.persSecCode == null && other.persSecCode != null) || (this.persSecCode != null && !this.persSecCode.equals(other.persSecCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopPersSector[ persSecCode=" + persSecCode + " ]";
	}
	
}
