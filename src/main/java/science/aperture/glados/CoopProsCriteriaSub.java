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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "coop_pros_criteria_sub")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsCriteriaSub.findAll", query = "SELECT c FROM CoopProsCriteriaSub c"),
	@NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaNo", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaNo = :subCriteriaNo"),
	@NamedQuery(name = "CoopProsCriteriaSub.findByMainSubNo", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.mainSubNo = :mainSubNo"),
	@NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaDtl = :subCriteriaDtl")})
public class CoopProsCriteriaSub implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_criteria_no")
	private Integer subCriteriaNo;
	@Basic(optional = false)
    @NotNull
    @Column(name = "main_sub_no")
	private int mainSubNo;
	@Size(max = 2147483647)
    @Column(name = "sub_criteria_dtl")
	private String subCriteriaDtl;
	@JoinColumn(name = "main_criteria_no", referencedColumnName = "main_criteria_no")
    @ManyToOne(optional = false)
	private CoopProsCriteriaMain mainCriteriaNo;
	@OneToMany(mappedBy = "subCriteriaNo")
	private Collection<CoopProsRatingSub> coopProsRatingSubCollection;

	public CoopProsCriteriaSub() {
	}

	public CoopProsCriteriaSub(Integer subCriteriaNo) {
		this.subCriteriaNo = subCriteriaNo;
	}

	public CoopProsCriteriaSub(Integer subCriteriaNo, int mainSubNo) {
		this.subCriteriaNo = subCriteriaNo;
		this.mainSubNo = mainSubNo;
	}

	public Integer getSubCriteriaNo() {
		return subCriteriaNo;
	}

	public void setSubCriteriaNo(Integer subCriteriaNo) {
		this.subCriteriaNo = subCriteriaNo;
	}

	public int getMainSubNo() {
		return mainSubNo;
	}

	public void setMainSubNo(int mainSubNo) {
		this.mainSubNo = mainSubNo;
	}

	public String getSubCriteriaDtl() {
		return subCriteriaDtl;
	}

	public void setSubCriteriaDtl(String subCriteriaDtl) {
		this.subCriteriaDtl = subCriteriaDtl;
	}

	public CoopProsCriteriaMain getMainCriteriaNo() {
		return mainCriteriaNo;
	}

	public void setMainCriteriaNo(CoopProsCriteriaMain mainCriteriaNo) {
		this.mainCriteriaNo = mainCriteriaNo;
	}

	@XmlTransient
	public Collection<CoopProsRatingSub> getCoopProsRatingSubCollection() {
		return coopProsRatingSubCollection;
	}

	public void setCoopProsRatingSubCollection(Collection<CoopProsRatingSub> coopProsRatingSubCollection) {
		this.coopProsRatingSubCollection = coopProsRatingSubCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subCriteriaNo != null ? subCriteriaNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsCriteriaSub)) {
			return false;
		}
		CoopProsCriteriaSub other = (CoopProsCriteriaSub) object;
		if ((this.subCriteriaNo == null && other.subCriteriaNo != null) || (this.subCriteriaNo != null && !this.subCriteriaNo.equals(other.subCriteriaNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopProsCriteriaSub[ subCriteriaNo=" + subCriteriaNo + " ]";
	}
	
}
