package util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hukai on 2017/6/29.
 */
public class ConectionTest {
    public static void main(String[] args) throws SQLException{
        ConectFactory cf=  ConectFactory.getInstance();
        Connection con=cf.makeConnection();
        System.out.print("aa"+con.getAutoCommit());
    }
}
