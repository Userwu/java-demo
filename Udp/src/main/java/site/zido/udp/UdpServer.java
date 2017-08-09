package site.zido.udp;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;

public class UdpServer {
    public static void main(String[] args){
        try(DatagramSocket server = new DatagramSocket(8010)){
            while (!"q".equals(UdpServer.getMsg(server))){
                System.out.println(System.currentTimeMillis()+"进行了一次交流");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMsg(DatagramSocket server) throws IOException {
        byte[] ctr = new byte[1024];
        DatagramPacket packet = new DatagramPacket(ctr,ctr.length);

        server.receive(packet);

        String msg = new String(ctr,0,packet.getLength());

        System.out.println("客户端发送数据为："+msg);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        SocketAddress socketAddress = packet.getSocketAddress();
        String result = "accepted";
        byte[] bytes = result.getBytes();
        DatagramPacket receivePacket = new DatagramPacket(bytes,bytes.length,socketAddress);
        server.send(receivePacket);
        return msg;
    }
}
