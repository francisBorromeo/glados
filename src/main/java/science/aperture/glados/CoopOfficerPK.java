/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mis
 */
@Embeddable
public class CoopOfficerPK implements Serializable {
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "coop_position")
	private String coopPosition;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ou_code")
	private String ouCode;
	@Basic(optional = false)
    @NotNull
    @Column(name = "term_start")
    @Temporal(TemporalType.DATE)
	private Date termStart;

	public CoopOfficerPK() {
	}

	public CoopOfficerPK(String coopPosition, String ouCode, Date termStart) {
		this.coopPosition = coopPosition;
		this.ouCode = ouCode;
		this.termStart = termStart;
	}

	public String getCoopPosition() {
		return coopPosition;
	}

	public void setCoopPosition(String coopPosition) {
		this.coopPosition = coopPosition;
	}

	public String getOuCode() {
		return ouCode;
	}

	public void setOuCode(String ouCode) {
		this.ouCode = ouCode;
	}

	public Date getTermStart() {
		return termStart;
	}

	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (coopPosition != null ? coopPosition.hashCode() : 0);
		hash += (ouCode != null ? ouCode.hashCode() : 0);
		hash += (termStart != null ? termStart.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopOfficerPK)) {
			return false;
		}
		CoopOfficerPK other = (CoopOfficerPK) object;
		if ((this.coopPosition == null && other.coopPosition != null) || (this.coopPosition != null && !this.coopPosition.equals(other.coopPosition))) {
			return false;
		}
		if ((this.ouCode == null && other.ouCode != null) || (this.ouCode != null && !this.ouCode.equals(other.ouCode))) {
			return false;
		}
		if ((this.termStart == null && other.termStart != null) || (this.termStart != null && !this.termStart.equals(other.termStart))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopOfficerPK[ coopPosition=" + coopPosition + ", ouCode=" + ouCode + ", termStart=" + termStart + " ]";
	}
	
}
