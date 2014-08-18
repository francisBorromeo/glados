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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "coop_non_member_relative")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopNonMemberRelative.findAll", query = "SELECT c FROM CoopNonMemberRelative c"),
	@NamedQuery(name = "CoopNonMemberRelative.findByRelativeRecordNo", query = "SELECT c FROM CoopNonMemberRelative c WHERE c.relativeRecordNo = :relativeRecordNo"),
	@NamedQuery(name = "CoopNonMemberRelative.findByLastName", query = "SELECT c FROM CoopNonMemberRelative c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "CoopNonMemberRelative.findByFirstName", query = "SELECT c FROM CoopNonMemberRelative c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "CoopNonMemberRelative.findByMiddleName", query = "SELECT c FROM CoopNonMemberRelative c WHERE c.middleName = :middleName"),
	@NamedQuery(name = "CoopNonMemberRelative.findByBirthdate", query = "SELECT c FROM CoopNonMemberRelative c WHERE c.birthdate = :birthdate")})
public class CoopNonMemberRelative implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relative_record_no")
	private Integer relativeRecordNo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
	private String lastName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
	private String firstName;
	@Size(max = 20)
    @Column(name = "middle_name")
	private String middleName;
	@Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
	private Date birthdate;

	public CoopNonMemberRelative() {
	}

	public CoopNonMemberRelative(Integer relativeRecordNo) {
		this.relativeRecordNo = relativeRecordNo;
	}

	public CoopNonMemberRelative(Integer relativeRecordNo, String lastName, String firstName, Date birthdate) {
		this.relativeRecordNo = relativeRecordNo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
	}

	public Integer getRelativeRecordNo() {
		return relativeRecordNo;
	}

	public void setRelativeRecordNo(Integer relativeRecordNo) {
		this.relativeRecordNo = relativeRecordNo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (relativeRecordNo != null ? relativeRecordNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopNonMemberRelative)) {
			return false;
		}
		CoopNonMemberRelative other = (CoopNonMemberRelative) object;
		if ((this.relativeRecordNo == null && other.relativeRecordNo != null) || (this.relativeRecordNo != null && !this.relativeRecordNo.equals(other.relativeRecordNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "science.aperture.glados.CoopNonMemberRelative[ relativeRecordNo=" + relativeRecordNo + " ]";
	}
	
}
