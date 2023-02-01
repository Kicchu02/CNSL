import java.io.*;
import java.net.*;
public class tcpclient 
{
 public static void main( String args[ ])throws Exception
 {
 Socket sock = new Socket( "127.0.0.1", 8080); 
 
System.out.println("Connection was accepted with server");
 System.out.println("Enter the file name");
 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
 String fname = keyRead.readLine(); 
 File f=new File(fname); 
 OutputStream ostream = sock.getOutputStream( );
 PrintWriter pwrite = new PrintWriter(ostream, true);
 pwrite.println(fname); 
 
if(!f.exists()||f.isDirectory())
 
{
 
System.out.println("file doesn't exist");
 
System.exit(0);
 
} 
 
 // receiving the contents from server. Uses input stream
 InputStream istream = sock.getInputStream();
 BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
 System.out.println("Server accepted the request...receiving file......\n");
 
System.out.println("Content of File");
System.out.println("---------------\n");
 String str;
 // reading line-by-line 
 while((str = socketRead.readLine()) != null) 
 { 
 System.out.println(str); 
 } 
 pwrite.close(); socketRead.close(); keyRead.close();
 sock.close();
 }
}