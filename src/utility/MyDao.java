/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package utility;
import java.sql.*;

/**
 *
 * @author frikky
 */
public class MyDao {
    public static MyDao md=null;
    private MyDao(){}
    public static MyDao getInstance(){
        if(md==null){
            md=new MyDao();
        }
        return md;
    }
    public Statement getConnection(String url,String user, String password) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password).createStatement();
    }
    public boolean dataloader(Statement st,String query) throws SQLException{
        return st.execute(query);
    }
    public ResultSet fetchData(Statement st,String query) throws SQLException{
        return st.executeQuery(query);
    }
}
