package com.jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

/**
 * Created by hukai on 2017/6/29.
 */
public class JDBCtest {
    public static Connection getConnection(){
      Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/jsp_db","root","888888");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  con;
    }
    public static  void  insert(){
        Connection con= getConnection();
        try {
            String sql="insert into tbl_user(name,password,email)"
                    +"values('Tom','2334','191124089@qq.com')";
            Statement st=con.createStatement();
            int count=st.executeUpdate(sql);
            System.out.print("一个更新了几条数据"+count);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static  void update(){
        Connection con =getConnection();
        try {
            String sql="update tbl_user set email='232222232@qq.cm' where name='Tom'";
            Statement st =con.createStatement();
            int count=st.executeUpdate(sql);
            System.out.print("一个更新了几条数据"+count);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static  void delete(){
        Connection con =getConnection();
        try {
            String sql="DELETE FROM tbl_user  where name='hukai'";
            Statement st =con.createStatement();
            int count=st.executeUpdate(sql);
            System.out.print("一个更新了几条数据"+count);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        insert();
        update();
        //delete();
//        String sql="select * from tbl_user";
//        Connection con =null;
//        Statement st=null;
//        ResultSet rs=null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con=(Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/jsp_db","root","888888");
//            st=con.createStatement();
//            rs= st.executeQuery(sql);
//            while (rs.next()){
//                System.out.println(rs.getInt("id"+""));
//                System.out.println(rs.getString("name"+""));
//                System.out.println(rs.getString("password"+""));
//                System.out.println(rs.getString("email"+""));
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace(
//
//            );
//
//        }  finally{
//            try {
//                rs.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//            try {
//                st.close();
//            } catch (Exception e3) {
//                e3.printStackTrace();
//            }
//            try {
//                con.close();
//            } catch (Exception e4) {
//                e4.printStackTrace();
//            }
//        };
//
    }

}
