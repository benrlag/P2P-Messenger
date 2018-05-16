import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class LocalServer{
	
	private ServerSocket ssock;
	private int port;
	ConcurrentHashMap<Integer, ReceivePeer> peers;
	
	LocalServer(int port, ConcurrentHashMap<Integer, ReceivePeer> peers){
		this.port = port;
		this.peers = peers;
	}
	
	public boolean openConnection(LinkedBlockingQueue<String> q){
		
		try {
			ssock = new ServerSocket(port);
			ReceivePeer rp = new ReceivePeer(ssock.accept(),q);
			rp.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	
}
