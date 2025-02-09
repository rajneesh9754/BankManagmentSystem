package bank.management.system;

import java.sql.*;


public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","rajneesh@1234");
            s = c.createStatement();
        }catch(Exception ec){
            System.out.println(ec);
        }
    }
}