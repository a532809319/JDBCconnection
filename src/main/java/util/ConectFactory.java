package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private static final ConectFactory factory = new ConectFactory();

    private Connection conn;

    static {
        Properties prop = new Properties();
        try {
            InputStream in = ConectFactory.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            prop.load(in);
        } catch (Exception e) {
            System.out.println("配置文件读取错误  " + e.getMessage());
        }

        driver = prop.getProperty("driver");
        System.out.print(driver);
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    private ConectFactory(){

    }

    public static ConectFactory getInstance(){
        return factory;
    }

    public Connection makeConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
//        Connection conn = ConectFactory.getInstance().makeConnection();
//        System.out.println(conn.getAutoCommit());
    }

}
