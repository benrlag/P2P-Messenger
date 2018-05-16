import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class Conversation {

	private Partner p;
	private ReceivePeer rpeer;
	private SendPeer speer;
	private LinkedBlockingQueue<String> incoming;
	private LinkedBlockingQueue<String> outgoing;
	private Socket sock;
	
	public Partner getP() {
		return p;
	}


	public void setP(Partner p) {
		this.p = p;
	}


	public ReceivePeer getRpeer() {
		return rpeer;
	}


	public void setRpeer(ReceivePeer rpeer) {
		this.rpeer = rpeer;
	}


	public SendPeer getSpeer() {
		return speer;
	}


	public void setSpeer(SendPeer speer) {
		this.speer = speer;
	}


	public LinkedBlockingQueue<String> getIncoming() {
		return incoming;
	}


	public void setIncoming(LinkedBlockingQueue<String> incoming) {
		this.incoming = incoming;
	}


	public LinkedBlockingQueue<String> getOutgoing() {
		return outgoing;
	}


	public void setOutgoing(LinkedBlockingQueue<String> outgoing) {
		this.outgoing = outgoing;
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}
	
}
