package site.zido.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket()){

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String msg = scanner.nextLine();

                byte[] buf = msg.getBytes();
                InetAddress address = InetAddress.getByName("127.0.0.1");
                int port = 8010;

                DatagramPacket packet = new DatagramPacket(buf,buf.length,address,port);



                socket.send(packet);


                byte[] backBuf = new byte[1024];
                DatagramPacket backPacket = new DatagramPacket(backBuf,backBuf.length);
                socket.receive(backPacket);

                String backMsg = new String(backBuf,0,backPacket.getLength());
                System.out.println("服务器返回消息："+backMsg);
                if("q".equals(msg)){
                    break;
                }
            }
            socket.close();
        } catch (SocketException e) {
            System.err.println("套接字错误");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.err.println("未找到服务器");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("io错误");
            e.printStackTrace();
        }

    }
}
