package com.devetibit.givemeblood.serviceinteraction;

import com.google.gson.annotations.Expose;

public class Donor_response {
	@Expose
	private int id;
	@Expose
	private String first_name;
	@Expose
	private String last_name;
	@Expose
	private String email;
	@Expose
	private String push_reg_id;
	@Expose
	private boolean locked;
	@Expose
	private String note;
	@Expose
	private String date_of_last_donation;
	@Expose
	private String created_at;
	@Expose
	private String updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPush_reg_id() {
		return push_reg_id;
	}
	public void setPush_reg_id(String push_reg_id) {
		this.push_reg_id = push_reg_id;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDate_of_last_donation() {
		return date_of_last_donation;
	}
	public void setDate_of_last_donation(String date_of_last_donation) {
		this.date_of_last_donation = date_of_last_donation;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
}
