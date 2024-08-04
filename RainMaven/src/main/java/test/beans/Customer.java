package test.beans;

public class Customer
{
	private int cid;
	private String cname;
	private String cemail;
	private String cphone;
	private String cpass;
	private String ccpass;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getCcpass() {
		return ccpass;
	}
	public void setCcpass(String ccpass) {
		this.ccpass = ccpass;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cphone=" + cphone + ", cpass="
				+ cpass + ", ccpass=" + ccpass + "]";
	}
	

}
