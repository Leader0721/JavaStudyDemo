package day15jdbc01;

import java.sql.*;

/**
 * Created by 83731 on 2017/09/17.
 * create table users(
 * id int primary key auto_increment,
 * name varchar(40),
 * password varchar(40),
 * email varchar(60),
 * birthday date
 * )character set utf8 collate utf8_general_ci;
 * insert into users(name,password,email,birthday) values('zs','123456','zs@sina.com','1980-12-04');
 * insert into users(name,password,email,birthday) values('lisi','123456','lisi@sina.com','1981-12-04');
 * insert into users(name,password,email,birthday) values('wangwu','123456','wangwu@sina.com','1979-12-04');
 * <p>
 * <p>
 * <p>
 * JDBC的编码步骤
 * 查询users表中的所有的数据 打印到控制台上
 */
public class JdbcDemo05 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;


//        1.注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());


//        2.获取和数据库的链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root", "123456");
            System.out.println(conn.getClass().getName());//如果想要知道驱动的具体类型，就这样进行打印
//        3.创建代表SQL语句的对象
            statement = conn.createStatement();

//        4.执行SQL语句
            resultSet = statement.executeQuery("select id,name,password,email,birthday from users");
//        5.如果是查询语句，需要遍历结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getObject("id"));//如果想要知道驱动的具体类型，就这样进行打印
                System.out.println(resultSet.getObject("name"));//如果想要知道驱动的具体类型，就这样进行打印
                System.out.println(resultSet.getObject("password"));//如果想要知道驱动的具体类型，就这样进行打印
                System.out.println(resultSet.getObject("email"));//如果想要知道驱动的具体类型，就这样进行打印
                System.out.println(resultSet.getObject("birthday"));//如果想要知道驱动的具体类型，就这样进行打印
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

//        6.释放占用的资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }


        }
    }
}
