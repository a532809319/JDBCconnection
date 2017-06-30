package dao.imp;

import dao.UserDao;
import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hukai on 2017/6/30.
 */
public class UserDaoImp implements UserDao {
    public void save(Connection con, User user) throws SQLException {
        PreparedStatement p=con.prepareCall("INSERT INTO  tbl_user(name,password,email)VALUES (?,?,?)");
        p.setString(1,user.getName());
        p.setString(2,user.getPassword());
        p.setString(3,user.getEmail());
        p.execute();
    }


    public void update(Connection con, Long id, User user) throws SQLException {
        PreparedStatement p= con.prepareCall("UPDATE tbl_user set name=?,password=?,email=? WHERE id=?");
        p.setString(1,user.getName());
        p.setString(2,user.getPassword());
        p.setString(3,user.getEmail());
        p.setLong(4,user.getId());
        p.execute();
    }

    public void delete(Connection con, User user) throws SQLException {
        PreparedStatement p = con.prepareCall("DELETE FROM tbl_user WHERE id=?");
        p.setLong(1, user.getId());
        p.execute();
    }

}
