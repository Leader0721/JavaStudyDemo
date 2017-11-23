package day15jdbc01;

import java.sql.*;
import java.util.Properties;

/**
 * statement详解
 * <p>
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
public class JdbcDemo03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        2.获取和数据库的链接
//        方式一
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root", "123456");
//        3.创建代表SQL语句的对象

        //statement详解

        Statement statement = conn.createStatement();
        int num = statement.executeUpdate("update users set password = 123456");
        System.out.println(num + "");//这个是修改了几行


        statement.close();
        conn.close();
    }
}
