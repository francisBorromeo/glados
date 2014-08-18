/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_report_circ")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopReportCirc.findAll", query = "SELECT c FROM CoopReportCirc c"),
	@NamedQuery(name = "CoopReportCirc.findByReportCircNum", query = "SELECT c FROM CoopReportCirc c WHERE c.reportCircNum = :reportCircNum")})
public class CoopReportCirc implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_circ_num")
	private Integer reportCircNum;
	@JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
	private CoopReport reportNum;
	@JoinColumn(name = "to_ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit toOuCode;

	public CoopReportCirc() {
	}

	public CoopReportCirc(Integer reportCircNum) {
		this.reportCircNum = reportCircNum;
	}

	public Integer getReportCircNum() {
		return reportCircNum;
	}

	public void setReportCircNum(Integer reportCircNum) {
		this.reportCircNum = reportCircNum;
	}

	public CoopReport getReportNum() {
		return reportNum;
	}

	public void setReportNum(CoopReport reportNum) {
		this.reportNum = reportNum;
	}

	public CoopOrgUnit getToOuCode() {
		return toOuCode;
	}

	public void setToOuCode(CoopOrgUnit toOuCode) {
		this.toOuCode = toOuCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (reportCircNum != null ? reportCircNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopReportCirc)) {
			return false;
		}
		CoopReportCirc other = (CoopReportCirc) object;
		if ((this.reportCircNum == null && other.reportCircNum != null) || (this.reportCircNum != null && !this.reportCircNum.equals(other.reportCircNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopReportCirc[ reportCircNum=" + reportCircNum + " ]";
	}
	
}
