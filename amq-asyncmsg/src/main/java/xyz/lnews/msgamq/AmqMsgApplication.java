package xyz.lnews.msgamq;

public class AmqMsgApplication {

	public static void main(String[] args) {
		AmqListenerApp listener = new AmqListenerApp();
		try {
			listener.listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
