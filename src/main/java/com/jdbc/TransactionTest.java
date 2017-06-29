package com.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hukai on 2017/6/29.
 */
public class TransactionTest {
    public static void main(String[] args) {
//        Connection con= DriverManager.getConnection()
        Connection con=null;
        try {
             con=getConnection();

            con.setAutoCommit(false);

            insertUserData(con);
             insertAddressData(con);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
               con.rollback();
                System.out.print("食物回滚");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        //  insertUserData(con);
           // insertAddressData(con);
    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/jsp_db","root","888888");

           // con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","888888");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void insertUserData(Connection con) throws SQLException{

     // Connection con=getConnection();
            String sql="insert into tbl_user(id,name ,password,email)"+"values('10','limeng','222asf','dsfa@qq.com')";
            Statement st=con.createStatement();
            int count=st.executeUpdate(sql);
            System.out.print("一个更新了几条数据"+count);
            //con.close();

    }
    public static void  insertAddressData(Connection con) throws SQLException{
        //Connection con=getConnection();
            String sql="insert into tbl_address(id,city ,country,user_id)"+"values('1','上海','中国','10')";
            Statement st=con.createStatement();
            int count=st.executeUpdate(sql);
            System.out.print("一个更新了几条数据"+count);
            con.close();

    }
}
