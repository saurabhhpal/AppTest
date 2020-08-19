package com.virtusa.fx.DAO;

public class FileObject {

	private Integer companyCode;
	private Long account;
	private String city;
	private String country;
	private String creditRating;
	private String currency;
	private double amount;

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FileObject [companyCode=" + companyCode + ", account=" + account + ", city=" + city + ", country="
				+ country + ", creditRating=" + creditRating + ", currency=" + currency + ", amount=" + amount + "]";
	}

}
