import java.net.*;
import java.io.*;
public class tcpserver 
{
public static void main(String[] args) throws Exception
{
 ServerSocket sersock = new ServerSocket(8080);
 System.out.println("Server ready for connection");
 Socket sock = sersock.accept(); 
 System.out.println("Connection is successful and wating for request");
 
 InputStream istream = sock.getInputStream( );
 BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
 String fname = fileRead.readLine( );
 
 File f=new File(fname);
 
if(!f.exists())
 
{
 
System.out.println("client requested file doesn't exist");
 
System.exit(0);
 
} 
 
System.out.println("A request for filename"+" " +fname+" "+ " is received");
 
 BufferedReader contentRead = new BufferedReader(new FileReader(fname) );
 OutputStream ostream = sock.getOutputStream( );
 PrintWriter pwrite = new PrintWriter(ostream, true);
 
 String str;
 while((str = contentRead.readLine()) != null) 
 {
pwrite.println(str); 
 }
 System.out.println("Request closed");
 sock.close(); 
 sersock.close(); 
 pwrite.close(); 
 fileRead.close(); 
 contentRead.close();
}
}