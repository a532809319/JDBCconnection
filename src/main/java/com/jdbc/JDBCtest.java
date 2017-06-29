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

    }
    public static void main(String[] args) {
        String sql="select * from tbl_user";
        Connection con =null;
        Statement st=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/jsp_db","root","888888");
            st=con.createStatement();
            rs= st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt("id"+""));
                System.out.println(rs.getString("name"+""));
                System.out.println(rs.getString("password"+""));
                System.out.println(rs.getString("email"+""));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace(

            );

        }  finally{
            try {
                rs.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                st.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        };

    }

}
