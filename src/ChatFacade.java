import java.util.HashMap;

public class ChatFacade implements ClientServerFacade{

	private LocalServer ls;
	
	ChatFacade(){
		//ls = new LocalServer();
	}
	
	@Override
	public boolean sendMessage(String message, Partner p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String retrieveMessage(Partner p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean connect(Partner p) {
		return false;
	}

	@Override
	public boolean startServer() {
		// TODO Auto-generated method stub
		return false;
	}

}