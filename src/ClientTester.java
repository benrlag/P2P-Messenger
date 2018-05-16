import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ClientTester {

	public static void main(String[] args) {
		Partner p = new Partner("10.71.51.185",7777);
		LinkedBlockingQueue<String> input = new LinkedBlockingQueue<String>();
		SendPeer sp = new SendPeer(p, input);
		sp.start();
		input.add("7777");
		Scanner sc = new Scanner(System.in);
		String in = "";
		while(true){
			in = sc.nextLine();
			if(in!=null){
				input.add(in);
				if(in.equals("kill")) break;
			}
		}
		sc.close();
	}

}
