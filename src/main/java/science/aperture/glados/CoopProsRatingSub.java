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
@Table(name = "coop_pros_rating_sub")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsRatingSub.findAll", query = "SELECT c FROM CoopProsRatingSub c"),
	@NamedQuery(name = "CoopProsRatingSub.findBySubProsRatingNo", query = "SELECT c FROM CoopProsRatingSub c WHERE c.subProsRatingNo = :subProsRatingNo"),
	@NamedQuery(name = "CoopProsRatingSub.findBySubCriteriaRating", query = "SELECT c FROM CoopProsRatingSub c WHERE c.subCriteriaRating = :subCriteriaRating")})
public class CoopProsRatingSub implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_pros_rating_no")
	private Integer subProsRatingNo;
	@Column(name = "sub_criteria_rating")
	private Integer subCriteriaRating;
	@JoinColumn(name = "sub_criteria_no", referencedColumnName = "sub_criteria_no")
    @ManyToOne
	private CoopProsCriteriaSub subCriteriaNo;
	@JoinColumn(name = "main_criteria_no", referencedColumnName = "main_criteria_no")
    @ManyToOne
	private CoopProsCriteriaMain mainCriteriaNo;

	public CoopProsRatingSub() {
	}

	public CoopProsRatingSub(Integer subProsRatingNo) {
		this.subProsRatingNo = subProsRatingNo;
	}

	public Integer getSubProsRatingNo() {
		return subProsRatingNo;
	}

	public void setSubProsRatingNo(Integer subProsRatingNo) {
		this.subProsRatingNo = subProsRatingNo;
	}

	public Integer getSubCriteriaRating() {
		return subCriteriaRating;
	}

	public void setSubCriteriaRating(Integer subCriteriaRating) {
		this.subCriteriaRating = subCriteriaRating;
	}

	public CoopProsCriteriaSub getSubCriteriaNo() {
		return subCriteriaNo;
	}

	public void setSubCriteriaNo(CoopProsCriteriaSub subCriteriaNo) {
		this.subCriteriaNo = subCriteriaNo;
	}

	public CoopProsCriteriaMain getMainCriteriaNo() {
		return mainCriteriaNo;
	}

	public void setMainCriteriaNo(CoopProsCriteriaMain mainCriteriaNo) {
		this.mainCriteriaNo = mainCriteriaNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subProsRatingNo != null ? subProsRatingNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsRatingSub)) {
			return false;
		}
		CoopProsRatingSub other = (CoopProsRatingSub) object;
		if ((this.subProsRatingNo == null && other.subProsRatingNo != null) || (this.subProsRatingNo != null && !this.subProsRatingNo.equals(other.subProsRatingNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopProsRatingSub[ subProsRatingNo=" + subProsRatingNo + " ]";
	}
	
}
