public interface ClientServerFacade {

	public boolean sendMessage(String message, Partner p);
	
	public String retrieveMessage(Partner p);
	
	public boolean connect(Partner p);
	
	public boolean startServer();

}


