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
@Table(name = "coop_ext_org_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopExtOrgAct.findAll", query = "SELECT c FROM CoopExtOrgAct c"),
	@NamedQuery(name = "CoopExtOrgAct.findByExtOrgActNum", query = "SELECT c FROM CoopExtOrgAct c WHERE c.extOrgActNum = :extOrgActNum")})
public class CoopExtOrgAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ext_org_act_num")
	private Integer extOrgActNum;
	@JoinColumn(name = "ext_org_no", referencedColumnName = "ext_org_no")
    @ManyToOne
	private CoopExtOrg extOrgNo;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopExtOrgAct() {
	}

	public CoopExtOrgAct(Integer extOrgActNum) {
		this.extOrgActNum = extOrgActNum;
	}

	public Integer getExtOrgActNum() {
		return extOrgActNum;
	}

	public void setExtOrgActNum(Integer extOrgActNum) {
		this.extOrgActNum = extOrgActNum;
	}

	public CoopExtOrg getExtOrgNo() {
		return extOrgNo;
	}

	public void setExtOrgNo(CoopExtOrg extOrgNo) {
		this.extOrgNo = extOrgNo;
	}

	public CoopActivity getActNum() {
		return actNum;
	}

	public void setActNum(CoopActivity actNum) {
		this.actNum = actNum;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (extOrgActNum != null ? extOrgActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopExtOrgAct)) {
			return false;
		}
		CoopExtOrgAct other = (CoopExtOrgAct) object;
		if ((this.extOrgActNum == null && other.extOrgActNum != null) || (this.extOrgActNum != null && !this.extOrgActNum.equals(other.extOrgActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopExtOrgAct[ extOrgActNum=" + extOrgActNum + " ]";
	}
	
}
