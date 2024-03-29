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
@Table(name = "coop_report")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopReport.findAll", query = "SELECT c FROM CoopReport c"),
	@NamedQuery(name = "CoopReport.findByReportNum", query = "SELECT c FROM CoopReport c WHERE c.reportNum = :reportNum"),
	@NamedQuery(name = "CoopReport.findByReportDtl", query = "SELECT c FROM CoopReport c WHERE c.reportDtl = :reportDtl"),
	@NamedQuery(name = "CoopReport.findByReportDateFrom", query = "SELECT c FROM CoopReport c WHERE c.reportDateFrom = :reportDateFrom"),
	@NamedQuery(name = "CoopReport.findByReportDateTo", query = "SELECT c FROM CoopReport c WHERE c.reportDateTo = :reportDateTo"),
	@NamedQuery(name = "CoopReport.findByReportDateEncoded", query = "SELECT c FROM CoopReport c WHERE c.reportDateEncoded = :reportDateEncoded")})
public class CoopReport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_num")
	private Integer reportNum;
	@Size(max = 2147483647)
    @Column(name = "report_dtl")
	private String reportDtl;
	@Column(name = "report_date_from")
    @Temporal(TemporalType.DATE)
	private Date reportDateFrom;
	@Column(name = "report_date_to")
    @Temporal(TemporalType.DATE)
	private Date reportDateTo;
	@Basic(optional = false)
    @NotNull
    @Column(name = "report_date_encoded")
    @Temporal(TemporalType.DATE)
	private Date reportDateEncoded;
	@OneToMany(mappedBy = "reportNum")
	private Collection<CoopProsReport> coopProsReportCollection;
	@OneToMany(mappedBy = "reportNum")
	private Collection<CoopOrgPlan> coopOrgPlanCollection;
	@OneToMany(mappedBy = "reportNum")
	private Collection<CoopRepAct> coopRepActCollection;
	@JoinColumn(name = "report_type_code", referencedColumnName = "report_type_code")
    @ManyToOne
	private CoopReportType reportTypeCode;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit ouCode;
	@JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
	private CoopMember memNo;
	@OneToMany(mappedBy = "reportNum")
	private Collection<CoopReportCirc> coopReportCircCollection;

	public CoopReport() {
	}

	public CoopReport(Integer reportNum) {
		this.reportNum = reportNum;
	}

	public CoopReport(Integer reportNum, Date reportDateEncoded) {
		this.reportNum = reportNum;
		this.reportDateEncoded = reportDateEncoded;
	}

	public Integer getReportNum() {
		return reportNum;
	}

	public void setReportNum(Integer reportNum) {
		this.reportNum = reportNum;
	}

	public String getReportDtl() {
		return reportDtl;
	}

	public void setReportDtl(String reportDtl) {
		this.reportDtl = reportDtl;
	}

	public Date getReportDateFrom() {
		return reportDateFrom;
	}

	public void setReportDateFrom(Date reportDateFrom) {
		this.reportDateFrom = reportDateFrom;
	}

	public Date getReportDateTo() {
		return reportDateTo;
	}

	public void setReportDateTo(Date reportDateTo) {
		this.reportDateTo = reportDateTo;
	}

	public Date getReportDateEncoded() {
		return reportDateEncoded;
	}

	public void setReportDateEncoded(Date reportDateEncoded) {
		this.reportDateEncoded = reportDateEncoded;
	}

	@XmlTransient
	public Collection<CoopProsReport> getCoopProsReportCollection() {
		return coopProsReportCollection;
	}

	public void setCoopProsReportCollection(Collection<CoopProsReport> coopProsReportCollection) {
		this.coopProsReportCollection = coopProsReportCollection;
	}

	@XmlTransient
	public Collection<CoopOrgPlan> getCoopOrgPlanCollection() {
		return coopOrgPlanCollection;
	}

	public void setCoopOrgPlanCollection(Collection<CoopOrgPlan> coopOrgPlanCollection) {
		this.coopOrgPlanCollection = coopOrgPlanCollection;
	}

	@XmlTransient
	public Collection<CoopRepAct> getCoopRepActCollection() {
		return coopRepActCollection;
	}

	public void setCoopRepActCollection(Collection<CoopRepAct> coopRepActCollection) {
		this.coopRepActCollection = coopRepActCollection;
	}

	public CoopReportType getReportTypeCode() {
		return reportTypeCode;
	}

	public void setReportTypeCode(CoopReportType reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public CoopOrgUnit getOuCode() {
		return ouCode;
	}

	public void setOuCode(CoopOrgUnit ouCode) {
		this.ouCode = ouCode;
	}

	public CoopMember getMemNo() {
		return memNo;
	}

	public void setMemNo(CoopMember memNo) {
		this.memNo = memNo;
	}

	@XmlTransient
	public Collection<CoopReportCirc> getCoopReportCircCollection() {
		return coopReportCircCollection;
	}

	public void setCoopReportCircCollection(Collection<CoopReportCirc> coopReportCircCollection) {
		this.coopReportCircCollection = coopReportCircCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (reportNum != null ? reportNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopReport)) {
			return false;
		}
		CoopReport other = (CoopReport) object;
		if ((this.reportNum == null && other.reportNum != null) || (this.reportNum != null && !this.reportNum.equals(other.reportNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopReport[ reportNum=" + reportNum + " ]";
	}
	
}
