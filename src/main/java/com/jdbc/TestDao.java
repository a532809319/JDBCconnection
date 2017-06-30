package com.jdbc;

import dao.UserDao;
import dao.imp.UserDaoImp;
import dto.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hukai on 2017/6/30.
 */
public class TestDao {
    public static void main(String[] args) {
        Connection con =null;
        try {
            con= ConnectionFactory.getInstance().makeConnection();
            con.setAutoCommit(false);
            UserDao userDao= new UserDaoImp();
            User tom= new User();
            tom.setName("tomson");
            tom.setPassword("2323");
            tom.getEmail();

            tom.setEmail("aba@com");
            userDao.save(con,tom);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
                System.out.println("回滚");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
