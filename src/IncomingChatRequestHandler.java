/**
 * Class to handle incoming chat requests.  Runs on its own thread.  Should be started at program startup.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class IncomingChatRequestHandler extends Thread {

	private ConcurrentHashMap<String, Conversation> conversations;
	int port;
	
	IncomingChatRequestHandler(ConcurrentHashMap<String, Conversation> conversations, int port){
		super("ServerHandler");
		this.conversations = conversations;
		this.port = port;
	}
	
	public void run(){
		
		try(
			//open server socket
			ServerSocket ssock = new ServerSocket(port);
		){
			//loop until kill command sent
			while(!Thread.currentThread().isInterrupted()){
				//check if incoming connection request is already in conversation map
				Socket tempSock = ssock.accept();
				String incomingIP = tempSock.getRemoteSocketAddress().toString();
				incomingIP = incomingIP.replace("/", "");
				incomingIP = incomingIP.split(":")[0];
				if(conversations.get(incomingIP)==null){
					System.out.println(incomingIP);
					//if it's not, add new conversation to map and initialize receive end
					Conversation tconv = new Conversation();
					conversations.put(incomingIP, tconv);
					tconv.setIncoming(new LinkedBlockingQueue<String>());
					tconv.setRpeer(new ReceivePeer(tempSock, tconv.getIncoming()));
					tconv.getRpeer().start();
					//wait for ping with peer's information, then set up send end
					while(true){
						String in = tconv.getIncoming().poll();
						if(in!=null){
							System.out.println(in);
							tconv.setP(new Partner(incomingIP, Integer.parseInt(in)));
							tconv.setOutgoing(new LinkedBlockingQueue<String>());
							tconv.setSpeer(new SendPeer(tconv.getP(),tconv.getOutgoing()));
							break;
						}
					}
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	
	public void kill(){
		interrupt();
	}
	
}
