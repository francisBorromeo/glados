/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_criteria_main")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsCriteriaMain.findAll", query = "SELECT c FROM CoopProsCriteriaMain c"),
	@NamedQuery(name = "CoopProsCriteriaMain.findByMainCriteriaNo", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.mainCriteriaNo = :mainCriteriaNo"),
	@NamedQuery(name = "CoopProsCriteriaMain.findByMainCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.mainCriteriaDtl = :mainCriteriaDtl"),
	@NamedQuery(name = "CoopProsCriteriaMain.findBySubCriteria", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.subCriteria = :subCriteria")})
public class CoopProsCriteriaMain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "main_criteria_no")
	private Integer mainCriteriaNo;
	@Size(max = 2147483647)
    @Column(name = "main_criteria_dtl")
	private String mainCriteriaDtl;
	@Column(name = "sub_criteria")
	private Boolean subCriteria;
	@JoinColumn(name = "criteria_set_no", referencedColumnName = "criteria_set_no")
    @ManyToOne(optional = false)
	private CoopProsCriteria criteriaSetNo;
	@OneToMany(mappedBy = "mainCriteriaNo")
	private Collection<CoopProsRatingMain> coopProsRatingMainCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mainCriteriaNo")
	private Collection<CoopProsCriteriaSub> coopProsCriteriaSubCollection;
	@OneToMany(mappedBy = "mainCriteriaNo")
	private Collection<CoopProsRatingSub> coopProsRatingSubCollection;

	public CoopProsCriteriaMain() {
	}

	public CoopProsCriteriaMain(Integer mainCriteriaNo) {
		this.mainCriteriaNo = mainCriteriaNo;
	}

	public Integer getMainCriteriaNo() {
		return mainCriteriaNo;
	}

	public void setMainCriteriaNo(Integer mainCriteriaNo) {
		this.mainCriteriaNo = mainCriteriaNo;
	}

	public String getMainCriteriaDtl() {
		return mainCriteriaDtl;
	}

	public void setMainCriteriaDtl(String mainCriteriaDtl) {
		this.mainCriteriaDtl = mainCriteriaDtl;
	}

	public Boolean getSubCriteria() {
		return subCriteria;
	}

	public void setSubCriteria(Boolean subCriteria) {
		this.subCriteria = subCriteria;
	}

	public CoopProsCriteria getCriteriaSetNo() {
		return criteriaSetNo;
	}

	public void setCriteriaSetNo(CoopProsCriteria criteriaSetNo) {
		this.criteriaSetNo = criteriaSetNo;
	}

	@XmlTransient
	public Collection<CoopProsRatingMain> getCoopProsRatingMainCollection() {
		return coopProsRatingMainCollection;
	}

	public void setCoopProsRatingMainCollection(Collection<CoopProsRatingMain> coopProsRatingMainCollection) {
		this.coopProsRatingMainCollection = coopProsRatingMainCollection;
	}

	@XmlTransient
	public Collection<CoopProsCriteriaSub> getCoopProsCriteriaSubCollection() {
		return coopProsCriteriaSubCollection;
	}

	public void setCoopProsCriteriaSubCollection(Collection<CoopProsCriteriaSub> coopProsCriteriaSubCollection) {
		this.coopProsCriteriaSubCollection = coopProsCriteriaSubCollection;
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
		hash += (mainCriteriaNo != null ? mainCriteriaNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsCriteriaMain)) {
			return false;
		}
		CoopProsCriteriaMain other = (CoopProsCriteriaMain) object;
		if ((this.mainCriteriaNo == null && other.mainCriteriaNo != null) || (this.mainCriteriaNo != null && !this.mainCriteriaNo.equals(other.mainCriteriaNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopProsCriteriaMain[ mainCriteriaNo=" + mainCriteriaNo + " ]";
	}
	
}
