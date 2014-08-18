/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package science.aperture.glados;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "masterfile2")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Masterfile2.findAll", query = "SELECT m FROM Masterfile2 m"),
	@NamedQuery(name = "Masterfile2.findByAcctno", query = "SELECT m FROM Masterfile2 m WHERE m.acctno = :acctno"),
	@NamedQuery(name = "Masterfile2.findByMembrNum", query = "SELECT m FROM Masterfile2 m WHERE m.membrNum = :membrNum"),
	@NamedQuery(name = "Masterfile2.findByMembrId", query = "SELECT m FROM Masterfile2 m WHERE m.membrId = :membrId"),
	@NamedQuery(name = "Masterfile2.findByLname", query = "SELECT m FROM Masterfile2 m WHERE m.lname = :lname"),
	@NamedQuery(name = "Masterfile2.findByFname", query = "SELECT m FROM Masterfile2 m WHERE m.fname = :fname"),
	@NamedQuery(name = "Masterfile2.findByMname", query = "SELECT m FROM Masterfile2 m WHERE m.mname = :mname"),
	@NamedQuery(name = "Masterfile2.findByNname", query = "SELECT m FROM Masterfile2 m WHERE m.nname = :nname"),
	@NamedQuery(name = "Masterfile2.findBySex", query = "SELECT m FROM Masterfile2 m WHERE m.sex = :sex"),
	@NamedQuery(name = "Masterfile2.findByBdate", query = "SELECT m FROM Masterfile2 m WHERE m.bdate = :bdate"),
	@NamedQuery(name = "Masterfile2.findByBplace", query = "SELECT m FROM Masterfile2 m WHERE m.bplace = :bplace"),
	@NamedQuery(name = "Masterfile2.findByCivstat", query = "SELECT m FROM Masterfile2 m WHERE m.civstat = :civstat"),
	@NamedQuery(name = "Masterfile2.findByHeight", query = "SELECT m FROM Masterfile2 m WHERE m.height = :height"),
	@NamedQuery(name = "Masterfile2.findByWeight", query = "SELECT m FROM Masterfile2 m WHERE m.weight = :weight"),
	@NamedQuery(name = "Masterfile2.findByResAdr", query = "SELECT m FROM Masterfile2 m WHERE m.resAdr = :resAdr"),
	@NamedQuery(name = "Masterfile2.findByBarangay", query = "SELECT m FROM Masterfile2 m WHERE m.barangay = :barangay"),
	@NamedQuery(name = "Masterfile2.findByCity", query = "SELECT m FROM Masterfile2 m WHERE m.city = :city"),
	@NamedQuery(name = "Masterfile2.findByRegion", query = "SELECT m FROM Masterfile2 m WHERE m.region = :region"),
	@NamedQuery(name = "Masterfile2.findByProvince", query = "SELECT m FROM Masterfile2 m WHERE m.province = :province"),
	@NamedQuery(name = "Masterfile2.findByResTelno", query = "SELECT m FROM Masterfile2 m WHERE m.resTelno = :resTelno"),
	@NamedQuery(name = "Masterfile2.findByOccptn", query = "SELECT m FROM Masterfile2 m WHERE m.occptn = :occptn"),
	@NamedQuery(name = "Masterfile2.findByBusAdr", query = "SELECT m FROM Masterfile2 m WHERE m.busAdr = :busAdr"),
	@NamedQuery(name = "Masterfile2.findByBusTelno", query = "SELECT m FROM Masterfile2 m WHERE m.busTelno = :busTelno"),
	@NamedQuery(name = "Masterfile2.findByEmpName", query = "SELECT m FROM Masterfile2 m WHERE m.empName = :empName"),
	@NamedQuery(name = "Masterfile2.findBySdcci", query = "SELECT m FROM Masterfile2 m WHERE m.sdcci = :sdcci"),
	@NamedQuery(name = "Masterfile2.findByTin", query = "SELECT m FROM Masterfile2 m WHERE m.tin = :tin"),
	@NamedQuery(name = "Masterfile2.findBySssGsis", query = "SELECT m FROM Masterfile2 m WHERE m.sssGsis = :sssGsis"),
	@NamedQuery(name = "Masterfile2.findByPtNo", query = "SELECT m FROM Masterfile2 m WHERE m.ptNo = :ptNo"),
	@NamedQuery(name = "Masterfile2.findByMemDate", query = "SELECT m FROM Masterfile2 m WHERE m.memDate = :memDate"),
	@NamedQuery(name = "Masterfile2.findBySpLname", query = "SELECT m FROM Masterfile2 m WHERE m.spLname = :spLname"),
	@NamedQuery(name = "Masterfile2.findBySpFname", query = "SELECT m FROM Masterfile2 m WHERE m.spFname = :spFname"),
	@NamedQuery(name = "Masterfile2.findBySpMname", query = "SELECT m FROM Masterfile2 m WHERE m.spMname = :spMname"),
	@NamedQuery(name = "Masterfile2.findBySpAcctno", query = "SELECT m FROM Masterfile2 m WHERE m.spAcctno = :spAcctno"),
	@NamedQuery(name = "Masterfile2.findByFather", query = "SELECT m FROM Masterfile2 m WHERE m.father = :father"),
	@NamedQuery(name = "Masterfile2.findByMother", query = "SELECT m FROM Masterfile2 m WHERE m.mother = :mother"),
	@NamedQuery(name = "Masterfile2.findByMbrstat", query = "SELECT m FROM Masterfile2 m WHERE m.mbrstat = :mbrstat"),
	@NamedQuery(name = "Masterfile2.findByChecked", query = "SELECT m FROM Masterfile2 m WHERE m.checked = :checked"),
	@NamedQuery(name = "Masterfile2.findByStatusDat", query = "SELECT m FROM Masterfile2 m WHERE m.statusDat = :statusDat"),
	@NamedQuery(name = "Masterfile2.findByDetNo", query = "SELECT m FROM Masterfile2 m WHERE m.detNo = :detNo")})
public class Masterfile2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(max = 8)
    @Column(name = "acctno")
	private String acctno;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "membr_num")
	private String membrNum;
	@Size(max = 10)
    @Column(name = "membr_id")
	private String membrId;
	@Size(max = 20)
    @Column(name = "lname")
	private String lname;
	@Size(max = 25)
    @Column(name = "fname")
	private String fname;
	@Size(max = 20)
    @Column(name = "mname")
	private String mname;
	@Size(max = 15)
    @Column(name = "nname")
	private String nname;
	@Column(name = "sex")
	private Character sex;
	@Column(name = "bdate")
    @Temporal(TemporalType.DATE)
	private Date bdate;
	@Size(max = 20)
    @Column(name = "bplace")
	private String bplace;
	@Column(name = "civstat")
	private Character civstat;
	@Size(max = 3)
    @Column(name = "height")
	private String height;
	@Size(max = 3)
    @Column(name = "weight")
	private String weight;
	@Size(max = 60)
    @Column(name = "res_adr")
	private String resAdr;
	@Size(max = 20)
    @Column(name = "barangay")
	private String barangay;
	@Size(max = 20)
    @Column(name = "city")
	private String city;
	@Size(max = 20)
    @Column(name = "region")
	private String region;
	@Size(max = 20)
    @Column(name = "province")
	private String province;
	@Size(max = 12)
    @Column(name = "res_telno")
	private String resTelno;
	@Size(max = 20)
    @Column(name = "occptn")
	private String occptn;
	@Size(max = 35)
    @Column(name = "bus_adr")
	private String busAdr;
	@Size(max = 8)
    @Column(name = "bus_telno")
	private String busTelno;
	@Size(max = 50)
    @Column(name = "emp_name")
	private String empName;
	@Column(name = "sdcci")
	private Boolean sdcci;
	@Size(max = 11)
    @Column(name = "tin")
	private String tin;
	@Size(max = 13)
    @Column(name = "sss_gsis")
	private String sssGsis;
	@Size(max = 5)
    @Column(name = "pt_no")
	private String ptNo;
	@Column(name = "mem_date")
    @Temporal(TemporalType.DATE)
	private Date memDate;
	@Size(max = 15)
    @Column(name = "sp_lname")
	private String spLname;
	@Size(max = 15)
    @Column(name = "sp_fname")
	private String spFname;
	@Size(max = 15)
    @Column(name = "sp_mname")
	private String spMname;
	@Size(max = 8)
    @Column(name = "sp_acctno")
	private String spAcctno;
	@Size(max = 35)
    @Column(name = "father")
	private String father;
	@Size(max = 35)
    @Column(name = "mother")
	private String mother;
	@Column(name = "mbrstat")
	private Character mbrstat;
	@Column(name = "checked")
	private Boolean checked;
	@Column(name = "status_dat")
    @Temporal(TemporalType.DATE)
	private Date statusDat;
	@Size(max = 2)
    @Column(name = "det_no")
	private String detNo;

	public Masterfile2() {
	}

	public Masterfile2(String membrNum) {
		this.membrNum = membrNum;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getMembrNum() {
		return membrNum;
	}

	public void setMembrNum(String membrNum) {
		this.membrNum = membrNum;
	}

	public String getMembrId() {
		return membrId;
	}

	public void setMembrId(String membrId) {
		this.membrId = membrId;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getBplace() {
		return bplace;
	}

	public void setBplace(String bplace) {
		this.bplace = bplace;
	}

	public Character getCivstat() {
		return civstat;
	}

	public void setCivstat(Character civstat) {
		this.civstat = civstat;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getResAdr() {
		return resAdr;
	}

	public void setResAdr(String resAdr) {
		this.resAdr = resAdr;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getResTelno() {
		return resTelno;
	}

	public void setResTelno(String resTelno) {
		this.resTelno = resTelno;
	}

	public String getOccptn() {
		return occptn;
	}

	public void setOccptn(String occptn) {
		this.occptn = occptn;
	}

	public String getBusAdr() {
		return busAdr;
	}

	public void setBusAdr(String busAdr) {
		this.busAdr = busAdr;
	}

	public String getBusTelno() {
		return busTelno;
	}

	public void setBusTelno(String busTelno) {
		this.busTelno = busTelno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Boolean getSdcci() {
		return sdcci;
	}

	public void setSdcci(Boolean sdcci) {
		this.sdcci = sdcci;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getSssGsis() {
		return sssGsis;
	}

	public void setSssGsis(String sssGsis) {
		this.sssGsis = sssGsis;
	}

	public String getPtNo() {
		return ptNo;
	}

	public void setPtNo(String ptNo) {
		this.ptNo = ptNo;
	}

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	public String getSpLname() {
		return spLname;
	}

	public void setSpLname(String spLname) {
		this.spLname = spLname;
	}

	public String getSpFname() {
		return spFname;
	}

	public void setSpFname(String spFname) {
		this.spFname = spFname;
	}

	public String getSpMname() {
		return spMname;
	}

	public void setSpMname(String spMname) {
		this.spMname = spMname;
	}

	public String getSpAcctno() {
		return spAcctno;
	}

	public void setSpAcctno(String spAcctno) {
		this.spAcctno = spAcctno;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public Character getMbrstat() {
		return mbrstat;
	}

	public void setMbrstat(Character mbrstat) {
		this.mbrstat = mbrstat;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Date getStatusDat() {
		return statusDat;
	}

	public void setStatusDat(Date statusDat) {
		this.statusDat = statusDat;
	}

	public String getDetNo() {
		return detNo;
	}

	public void setDetNo(String detNo) {
		this.detNo = detNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (membrNum != null ? membrNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Masterfile2)) {
			return false;
		}
		Masterfile2 other = (Masterfile2) object;
		if ((this.membrNum == null && other.membrNum != null) || (this.membrNum != null && !this.membrNum.equals(other.membrNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.Masterfile2[ membrNum=" + membrNum + " ]";
	}
	
}
