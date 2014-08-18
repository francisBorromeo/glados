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
@Table(name = "coop_pros_rating_main")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsRatingMain.findAll", query = "SELECT c FROM CoopProsRatingMain c"),
	@NamedQuery(name = "CoopProsRatingMain.findByMainProsRatingNo", query = "SELECT c FROM CoopProsRatingMain c WHERE c.mainProsRatingNo = :mainProsRatingNo"),
	@NamedQuery(name = "CoopProsRatingMain.findByMainCriteriaRating", query = "SELECT c FROM CoopProsRatingMain c WHERE c.mainCriteriaRating = :mainCriteriaRating")})
public class CoopProsRatingMain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "main_pros_rating_no")
	private Integer mainProsRatingNo;
	@Column(name = "main_criteria_rating")
	private Integer mainCriteriaRating;
	@JoinColumn(name = "pros_rep_num", referencedColumnName = "pros_rep_num")
    @ManyToOne
	private CoopProsReport prosRepNum;
	@JoinColumn(name = "main_criteria_no", referencedColumnName = "main_criteria_no")
    @ManyToOne
	private CoopProsCriteriaMain mainCriteriaNo;

	public CoopProsRatingMain() {
	}

	public CoopProsRatingMain(Integer mainProsRatingNo) {
		this.mainProsRatingNo = mainProsRatingNo;
	}

	public Integer getMainProsRatingNo() {
		return mainProsRatingNo;
	}

	public void setMainProsRatingNo(Integer mainProsRatingNo) {
		this.mainProsRatingNo = mainProsRatingNo;
	}

	public Integer getMainCriteriaRating() {
		return mainCriteriaRating;
	}

	public void setMainCriteriaRating(Integer mainCriteriaRating) {
		this.mainCriteriaRating = mainCriteriaRating;
	}

	public CoopProsReport getProsRepNum() {
		return prosRepNum;
	}

	public void setProsRepNum(CoopProsReport prosRepNum) {
		this.prosRepNum = prosRepNum;
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
		hash += (mainProsRatingNo != null ? mainProsRatingNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsRatingMain)) {
			return false;
		}
		CoopProsRatingMain other = (CoopProsRatingMain) object;
		if ((this.mainProsRatingNo == null && other.mainProsRatingNo != null) || (this.mainProsRatingNo != null && !this.mainProsRatingNo.equals(other.mainProsRatingNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopProsRatingMain[ mainProsRatingNo=" + mainProsRatingNo + " ]";
	}
	
}
