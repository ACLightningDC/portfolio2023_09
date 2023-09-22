package vo.login;

public class OTP {
	private String encodedKey;
	private String url;
	
	
	public OTP() {}
	
	public OTP(String encodedKey, String url) {
		super();
		this.encodedKey = encodedKey;
		this.url = url;
	}
	
	public String getEncodedKey() {
		return encodedKey;
	}
	public void setEncodedKey(String encodedKey) {
		this.encodedKey = encodedKey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
