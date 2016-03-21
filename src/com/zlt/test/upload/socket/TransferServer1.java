package com.zlt.test.upload.socket;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.File;
import java.io.FileOutputStream;  
import java.io.RandomAccessFile;
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 
public class TransferServer1 {
	private int defaultBindPort = Constants.DEFAULT_BIND_PORT;    //Ĭ�ϼ����˿ں�Ϊ10000  
    private int tryBindTimes = 0;           //��ʼ�İ󶨶˿ڵĴ����趨Ϊ0  
    private ServerSocket serverSocket;      //�����׽��ֵȴ��Է������Ӻ��ļ�����  
    private ExecutorService executorService;    //�̳߳�  
    private final int POOL_SIZE = 4;            //����CPU���̳߳ش�С   
      
    /** 
     * ���������Ĺ�������ѡ��Ĭ�ϵĶ˿ں� 
     * @throws Exception 
     */  
    public TransferServer1() throws Exception{  
        try {  
            this.bingToServerPort(defaultBindPort);  
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL_SIZE);  
            System.out.println("�����߳��� �� " + Runtime.getRuntime().availableProcessors() * POOL_SIZE);  
        } catch (Exception e) {  
            throw new Exception("�󶨶˿ڲ��ɹ�!");  
        }  
    }  
      
    /** 
     * �������Ĺ�������ѡ���û�ָ���Ķ˿ں� 
     * @param port 
     * @throws Exception 
     */  
    public TransferServer1(int port) throws Exception{  
        try {  
            this.bingToServerPort(port);  
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL_SIZE);  
        } catch (Exception e) {  
            throw new Exception("�󶨶˿ڲ��ɹ�!");  
        }  
    }  
      
    private void bingToServerPort(int port) throws Exception{  
        try {  
            serverSocket = new ServerSocket(port);  
            System.out.println(port);  
            System.out.println("��������!");  
        } catch (Exception e) {  
            this.tryBindTimes = this.tryBindTimes + 1;  
            port = port + this.tryBindTimes;  
            if(this.tryBindTimes >= 20){  
                throw new Exception("���Ѿ����Ժܶ���ˣ��������޷��󶨵�ָ���Ķ˿�!������ѡ��󶨵�Ĭ�϶˿ں�");  
            }  
            //�ݹ�󶨶˿�  
            this.bingToServerPort(port);  
            //TODO
        }  
    }  
      
    public void service(){  
        Socket socket = null;  
        while (true) {  
            try {  
                socket = serverSocket.accept();  
                executorService.execute(new Handler(socket));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
  
    class Handler implements Runnable{  
        private Socket socket;  
          
        public Handler(Socket socket){  
            this.socket = socket;  
        }  
  
        public void run() {  
              
            System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());  
              
            DataInputStream dis = null;  
            DataOutputStream dos = null;  
            DataOutputStream dsm = null;
  
            int bufferSize = 8192;  
            byte[] buf = new byte[bufferSize];  
              
            try {  
                dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));  
                dsm = new DataOutputStream(socket.getOutputStream());
                String savePath = Constants.RECEIVE_FILE_PATH + dis.readUTF();  
                long length = dis.readLong();  
                File file = new File(savePath);
                if(file.exists()){
                	System.out.println("�ļ�["+file.getName()+"]����������");
                	long fileLength = file.length();
                	
                	dsm.writeUTF(fileLength+"");
                	dsm.flush();
                	RandomAccessFile raf = new RandomAccessFile(savePath,"rw");
//                	System.out.println("�ļ����λ��:"+savePath);
//                	System.out.println("�������ȱ��:"+fileLength);
                	
                	int start = (int)fileLength;
                	int amount = 0;
                	raf.seek(fileLength);
                	while((amount = dis.read(buf))!=-1){
                		raf.write(buf,0,amount);
                		start = start + amount;
//                		System.out.println("�ļ�["+file.getName()+"]�ѽ���:"+start*100L/length+"%");
                	}
//                	System.out.println("�ļ����ս���!");
                	raf.close();
                	this.socket.shutdownInput();
                	dsm.writeUTF("90000");
                	System.out.println("�ļ�["+file.getName()+"]���ճɹ�2 : 90000");
                }else{
                	System.out.println("�ļ�["+file.getName()+"]������ֱ�Ӵ���!");
                	dsm.writeUTF("noexsits");
                	dsm.flush();
                	dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(savePath)));
                	int read = 0;  
                    long passedlen = 0;  
                    while ((read = dis.read(buf)) != -1) {  
                        passedlen += read;  
                        dos.write(buf, 0, read);  
//                        System.out.println("�ļ�[" + savePath + "]�Ѿ�����: " + passedlen * 100L/ length + "%");  
                    }  
//                    
                    this.socket.shutdownInput();
                    dsm.writeUTF("90000");
                    System.out.println("�ļ�["+file.getName()+"]���ճɹ�1 : 90000");
                }
                  
                  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
                System.out.println("�����ļ�ʧ��!");  
            }finally{  
                try {  
                    if(dos != null){  
                        dos.close();  
                    }  
                    if(dis != null){  
                        dis.close();  
                    }  
                    if(dsm !=null){
                    	dsm.close();
                    }
                    if(socket != null){  
                        socket.close();  
                    }  
                    System.gc();
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
      
    public static void main(String[] args) throws Exception{  
        new TransferServer1().service();  
    }  

}
