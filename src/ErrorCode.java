
public enum ErrorCode {

	ERRCD0001("Connection reset");
	
	private final String printcode;
	
	ErrorCode(String printcode){
		this.printcode = printcode;
	}
	
	public String getPrintCode(){
		return printcode;
	}
	
}
