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
@Table(name = "coop_pers_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopPersAct.findAll", query = "SELECT c FROM CoopPersAct c"),
	@NamedQuery(name = "CoopPersAct.findByPersActNum", query = "SELECT c FROM CoopPersAct c WHERE c.persActNum = :persActNum")})
public class CoopPersAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_act_num")
	private Integer persActNum;
	@JoinColumn(name = "pers_id_no", referencedColumnName = "pers_id_no")
    @ManyToOne
	private CoopPersonality persIdNo;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopPersAct() {
	}

	public CoopPersAct(Integer persActNum) {
		this.persActNum = persActNum;
	}

	public Integer getPersActNum() {
		return persActNum;
	}

	public void setPersActNum(Integer persActNum) {
		this.persActNum = persActNum;
	}

	public CoopPersonality getPersIdNo() {
		return persIdNo;
	}

	public void setPersIdNo(CoopPersonality persIdNo) {
		this.persIdNo = persIdNo;
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
		hash += (persActNum != null ? persActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopPersAct)) {
			return false;
		}
		CoopPersAct other = (CoopPersAct) object;
		if ((this.persActNum == null && other.persActNum != null) || (this.persActNum != null && !this.persActNum.equals(other.persActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopPersAct[ persActNum=" + persActNum + " ]";
	}
	
}
