// program for client(hello server)from server 

//import java.net.*;
// import java.io.*;
// public class MyClient {
//  public static void main(String args[]){
//             try{
//             Socket s = new Socket("localhost",6666);
//             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//             dos.writeUTF("hello server");
//             dos.flush();
//             dos.close();
//             s.close();
// }
// catch(Exception e){
//     e.printStackTrace();
// }
//     }
// }



import java.net.*;
import java.io.*;
public class MyClient {
 public static void main(String args[]){
            try{
            Socket s = new Socket("localhost",6666);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str1 = "";
            String str2 = "";

            while(!str1.equals("stop")){
                str1 = br.readLine();
                dos.writeUTF(str1);
                dos.flush();
                if(!str1.equals("stop")){
                str2 = dis.readUTF();
                System.out.println("Server says: " + str2);
                }
                else{
                    System.out.println("server has stopped the connecton!!");
                }
           }
            dis.close();
            dos.close();
            s.close();
}
catch(Exception e){
    e.printStackTrace();
}
    }
}
