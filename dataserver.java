import java.net.*; 
import java.util.Scanner; 
public class dataserver
{ 
 public static void main(String[] args) throws Exception
 { 
 DatagramSocket ds = new DatagramSocket(); 
 System.out.println("Enter the Message");
 Scanner sc=new Scanner(System.in);
 String str=sc.nextLine();
 InetAddress ip = InetAddress.getByName("127.0.0.1"); 
 DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000); 
 ds.send(dp); 
 ds.close();
 
 } 
} 