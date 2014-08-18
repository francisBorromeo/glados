/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_officer")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopOfficer.findAll", query = "SELECT c FROM CoopOfficer c"),
	@NamedQuery(name = "CoopOfficer.findByCoopPosition", query = "SELECT c FROM CoopOfficer c WHERE c.coopOfficerPK.coopPosition = :coopPosition"),
	@NamedQuery(name = "CoopOfficer.findByOuCode", query = "SELECT c FROM CoopOfficer c WHERE c.coopOfficerPK.ouCode = :ouCode"),
	@NamedQuery(name = "CoopOfficer.findByTermStart", query = "SELECT c FROM CoopOfficer c WHERE c.coopOfficerPK.termStart = :termStart"),
	@NamedQuery(name = "CoopOfficer.findByTermEnd", query = "SELECT c FROM CoopOfficer c WHERE c.termEnd = :termEnd")})
public class CoopOfficer implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CoopOfficerPK coopOfficerPK;
	@Column(name = "term_end")
    @Temporal(TemporalType.DATE)
	private Date termEnd;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private CoopOrgUnit coopOrgUnit;
	@JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
	private CoopMember memNo;

	public CoopOfficer() {
	}

	public CoopOfficer(CoopOfficerPK coopOfficerPK) {
		this.coopOfficerPK = coopOfficerPK;
	}

	public CoopOfficer(String coopPosition, String ouCode, Date termStart) {
		this.coopOfficerPK = new CoopOfficerPK(coopPosition, ouCode, termStart);
	}

	public CoopOfficerPK getCoopOfficerPK() {
		return coopOfficerPK;
	}

	public void setCoopOfficerPK(CoopOfficerPK coopOfficerPK) {
		this.coopOfficerPK = coopOfficerPK;
	}

	public Date getTermEnd() {
		return termEnd;
	}

	public void setTermEnd(Date termEnd) {
		this.termEnd = termEnd;
	}

	public CoopOrgUnit getCoopOrgUnit() {
		return coopOrgUnit;
	}

	public void setCoopOrgUnit(CoopOrgUnit coopOrgUnit) {
		this.coopOrgUnit = coopOrgUnit;
	}

	public CoopMember getMemNo() {
		return memNo;
	}

	public void setMemNo(CoopMember memNo) {
		this.memNo = memNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (coopOfficerPK != null ? coopOfficerPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopOfficer)) {
			return false;
		}
		CoopOfficer other = (CoopOfficer) object;
		if ((this.coopOfficerPK == null && other.coopOfficerPK != null) || (this.coopOfficerPK != null && !this.coopOfficerPK.equals(other.coopOfficerPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopOfficer[ coopOfficerPK=" + coopOfficerPK + " ]";
	}
	
}
