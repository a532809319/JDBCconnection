package dao;

import dto.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hukai on 2017/6/30.
 */
public interface UserDao {
    public  void  save(Connection con , User user) throws SQLException;
    public  void  update(Connection con ,Long id,User user)throws  SQLException;
    public  void  delete(Connection con  ,User user)throws  SQLException;
}
