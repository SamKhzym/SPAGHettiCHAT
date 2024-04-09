import java.rmi.*;

public class MyServer{

    public static void main(String args[]){
        try{
            //System.setProperty("java.rmi.server.hostname","localhost");
            Adder stub=new AdderRemote();
            Naming.rebind("rmi://localhost:8000/sonoo",stub);
            System.out.println("Server Connected!");
        }catch(Exception e){System.out.println(e);}
    }

}