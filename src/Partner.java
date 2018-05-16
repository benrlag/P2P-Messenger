
public class Partner {

	private String ip;
	private int port;
	
	Partner(){
		setIp(null);
		setPort(-1);
	}
	
	Partner(String ip, int port){
		setIp(ip);
		setPort(port);
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
