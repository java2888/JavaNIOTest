package nioclient;

import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class Handle implements Runnable {
	private Socket socket;
    private int count=0;
	public Handle(Socket socket, int count) {
		this.socket = socket;
		this.count=count;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String strOutput;
			strOutput ="当前是第:[" + count+"]个线程" + Thread.currentThread().getName();
			bw.write(strOutput+"\r\n");
			bw.flush();
			String strInput;
			while ((strInput = br.readLine()) != null) {
				System.out.println(strInput);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class NIOClient_6 {
	private static String hostName = "127.0.0.1";
	private static final int port = 8080;
    private static Object obj=new Object();
	private static int count=0;
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				Socket socket = new Socket(hostName, port);
				Thread myThread = new Thread(new Handle(socket, count));
				addCount();
				myThread.start();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void addCount(){		
		synchronized(obj){
			count++;
			//System.out.println("��ǰ�ǵ�["+count+"]�߳�.");
		}
	}

}
