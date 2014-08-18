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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pers_ext_org")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopPersExtOrg.findAll", query = "SELECT c FROM CoopPersExtOrg c"),
	@NamedQuery(name = "CoopPersExtOrg.findByPersExtOrgNum", query = "SELECT c FROM CoopPersExtOrg c WHERE c.persExtOrgNum = :persExtOrgNum"),
	@NamedQuery(name = "CoopPersExtOrg.findByRankPos", query = "SELECT c FROM CoopPersExtOrg c WHERE c.rankPos = :rankPos")})
public class CoopPersExtOrg implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_ext_org_num")
	private Integer persExtOrgNum;
	@Size(max = 15)
    @Column(name = "rank_pos")
	private String rankPos;
	@JoinColumn(name = "pers_id_no", referencedColumnName = "pers_id_no")
    @ManyToOne
	private CoopPersonality persIdNo;
	@JoinColumn(name = "ext_org_no", referencedColumnName = "ext_org_no")
    @ManyToOne
	private CoopExtOrg extOrgNo;

	public CoopPersExtOrg() {
	}

	public CoopPersExtOrg(Integer persExtOrgNum) {
		this.persExtOrgNum = persExtOrgNum;
	}

	public Integer getPersExtOrgNum() {
		return persExtOrgNum;
	}

	public void setPersExtOrgNum(Integer persExtOrgNum) {
		this.persExtOrgNum = persExtOrgNum;
	}

	public String getRankPos() {
		return rankPos;
	}

	public void setRankPos(String rankPos) {
		this.rankPos = rankPos;
	}

	public CoopPersonality getPersIdNo() {
		return persIdNo;
	}

	public void setPersIdNo(CoopPersonality persIdNo) {
		this.persIdNo = persIdNo;
	}

	public CoopExtOrg getExtOrgNo() {
		return extOrgNo;
	}

	public void setExtOrgNo(CoopExtOrg extOrgNo) {
		this.extOrgNo = extOrgNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (persExtOrgNum != null ? persExtOrgNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopPersExtOrg)) {
			return false;
		}
		CoopPersExtOrg other = (CoopPersExtOrg) object;
		if ((this.persExtOrgNum == null && other.persExtOrgNum != null) || (this.persExtOrgNum != null && !this.persExtOrgNum.equals(other.persExtOrgNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopPersExtOrg[ persExtOrgNum=" + persExtOrgNum + " ]";
	}
	
}
