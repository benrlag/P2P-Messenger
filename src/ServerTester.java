import java.util.concurrent.ConcurrentHashMap;

public class ServerTester {
	
	private static ConcurrentHashMap<String, Conversation> chm;
	
	public static void main(String[] args){
		
		chm = new ConcurrentHashMap<String, Conversation>();
		
		IncomingChatRequestHandler sh = new IncomingChatRequestHandler(chm, 7777);
		sh.start();
		
		listen("10.71.51.185");
		listen("10.71.51.185");
		
		sh.kill();
		
		System.exit(0);
		
	}
	
	public static void listen(String ip){
		boolean keepgoing = true;
				
		while(keepgoing){
			Conversation c = chm.get(ip);
			if(c!=null){
				if(c.getIncoming()!=null){
					String p = c.getIncoming().poll();
					if(p!=null){
						for(ErrorCode ec : ErrorCode.values()){
							if(p.equals(ec.toString())){
								System.out.println("P2P Error: " + ec.getPrintCode());
								keepgoing = false;
								chm.remove(ip);
								break;
							}
						}
						if(keepgoing) System.out.println(p);
					}
				}
			}
		}
				
				
	}

}
