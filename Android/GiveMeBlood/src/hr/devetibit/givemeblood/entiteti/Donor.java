package hr.devetibit.givemeblood.entiteti;


public class Donor {
	private int id_donor;
	private String ime, prezime, email, id_push_reg, note, date_of_birth, genter;
	
	public int getIdDonor() {
		return this.id_donor;
	}
	public void setIdDonor(int id_donor) {
		this.id_donor = id_donor;
	}
	public int getGenter() {
		if (genter == "male")
			return 0;
		else
			return 1;
	}
	public void setGenter(int id_genter) {
		if (id_genter == 0)
			this.genter = "male";
		else
			this.genter = "female";
	}
	public String getIme() {
		return this.ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return this.prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdPushReg() {
		return this.id_push_reg;
	}
	public void setIdPushReg(String id) {
		this.id_push_reg = id;
	}
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDateOfBirth() {
		return this.date_of_birth;
	}
	public void setDateOfBirth(String date) {
		this.date_of_birth = date;
	}
	
	public Donor(int id, String id_push) {
		this.setIdDonor(id);
		this.setIme("");
		this.setPrezime("");
		this.setEmail("");
		this.setNote("");
		this.setGenter(0);
		this.setDateOfBirth("");
		this.setIdPushReg(id_push);
	}
	
	public void getAge() {
		//Date.parse(string);
	}
}
