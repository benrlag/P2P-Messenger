import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class ReceivePeer extends Thread{

	private Socket s;
	private LinkedBlockingQueue<String> q;
	
	ReceivePeer(Socket s, LinkedBlockingQueue<String> q){
		super("ReceivePeer");
		this.s = s;
		this.q = q;
	}
	
	 public void run() {
		 
	        try (
	            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        ) {
	            String incoming = "";
	 
	            while(true) {
	                if((incoming = in.readLine()) != null){
	                	q.add(incoming);
	                }
	            }
	            /*
	            out.close();
	            in.close();
	            s.close();*/
	        } catch (SocketException se){
	        	q.add("ERRCD0001");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	    }
	
	 public void kill(){
		 interrupt();
	 }
}
