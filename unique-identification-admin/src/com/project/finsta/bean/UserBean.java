package com.project.finsta.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class UserBean {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="profile")
	private String profile;
	


	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="city")
	private String city;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="adhar_number")
	private String adharNumber;
	
	@Column(name="pan_number")
	private String panNumber;
	
	@Column(name="driving_licence")
	private String drivingLicence;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="ration_card")
	private String rationCard;
	
	@Column(name="passport_expire_date")
	private String passportExpireDate;
	
	@Column(name="street")
	private String street;
	
	@Column(name="state")
	private String state;
	
	@Column(name="wallet")
	private String wallet;
	
	@Column(name="verify_user")
	private String verifyUser;

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getRationCard() {
		return rationCard;
	}

	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}

	public String getPassportExpireDate() {
		return passportExpireDate;
	}

	public void setPassportExpireDate(String passportExpireDate) {
		this.passportExpireDate = passportExpireDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", profile=" + profile + ", contactNumber="
				+ contactNumber + ", city=" + city + ", sex=" + sex + ", middleName=" + middleName + ", bloodGroup="
				+ bloodGroup + ", dateOfBirth=" + dateOfBirth + ", adharNumber=" + adharNumber + ", panNumber="
				+ panNumber + ", drivingLicence=" + drivingLicence + ", passportNumber=" + passportNumber
				+ ", rationCard=" + rationCard + ", passportExpireDate=" + passportExpireDate + ", street=" + street
				+ ", state=" + state + ", wallet=" + wallet + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
