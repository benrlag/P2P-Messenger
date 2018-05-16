import java.util.HashMap;

public class ChatFacadeTest implements ClientServerFacade {
	
	public ChatFacade chat;
	private LocalServer ls;
	
	@Override
	public boolean sendMessage(String message, Partner p) {
		//String sendtest = "TEST STRING SENT";
		String text = message;
		Partner identity = p;
		if(text == null){
			return false;
		}
		if(identity == null){
			return false;
		}
		
		if(chat.sendMessage(text, identity) != this.sendMessage(text, identity)){
			return false;
		}
		
		return true;
	}

	@Override
	public String retrieveMessage(Partner p) {
		String sendtest = "TEST STRING SENT";
		Partner identity = p;
		if(identity == null){
			return "NULL IDENTITY";
		}
		
		if(chat.retrieveMessage(identity) != this.retrieveMessage(identity)){
			return "RETRIEVE MESSAGE FAIL";
		}
		
		return null;
	}

	@Override
	public boolean connect(Partner p) {
		Partner identity = p;
		if(identity == null){
			return false;
		}
		
		if(chat.connect(identity) != this.connect(identity)){
			return false;
		}
		
		return true;
	}

	@Override
	public boolean startServer() {
		if(chat.startServer() != this.startServer()){
			return false;
		}
		return true;
	}

}
