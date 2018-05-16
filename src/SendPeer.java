import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;

public class SendPeer extends Thread{

	private Partner p;
	private LinkedBlockingQueue<String> q;
	
	SendPeer(Partner p, LinkedBlockingQueue<String> q){
		super("SendPeer");
		this.p = p;
		this.q = q;
	}
	
	public void run(){
		
		try(
			Socket sock = new Socket(p.getIp(), p.getPort());
				PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
		){

			String outgoing = "";

			
			while(true){
				if((outgoing = q.poll())!=null){
					out.println(outgoing);
				}
			}
			/*
			out.close();
			sock.close();*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void kill(){
		interrupt();
	}
	
	
}
