// import java.net.*;
// import java.io.*;
// public class MyServer {
// public static void main(String args[]){
//     try{
//         ServerSocket ss = new ServerSocket(6666);
//         Socket s = ss.accept();
//         DataInputStream dis = new DataInputStream(s.getInputStream());
    
//         String str = dis.readUTF();
//         System.out.println(str);
//             s.close();
//             ss.close();
//     }
//     catch(Exception e){
//         e.printStackTrace();
//     }

// }    
// }




import java.net.*;
import java.io.*;
public class MyServer {
public static void main(String args[]){
    try{
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
         while(!str1.equals("stop")){
             str1 = dis.readUTF();
             System.out.println("Client says: " + str1);
             if(!str1.equals("stop")){
             str2 = br.readLine();
            dos.writeUTF(str2);
            dos.flush();
        }
            else{
                dos.flush();  
            }
         }
           dis.close();
           dos.close();
            s.close();
            ss.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }

}    
}
