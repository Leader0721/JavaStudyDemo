package day15jdbc01;

import java.sql.*;
import java.util.Properties;

/**
 * 对Demo01的改进
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
public class JdbcDemo02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        1.注册驱动
        //方式一   不建议使用  因为注册了两遍
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //方式二   建议使用
        Class.forName("com.mysql.jdbc.Driver");
//        2.获取和数据库的链接
//        方式一
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root", "123456");
//        方式二
        Properties properties = new Properties();
        properties.setProperty("user", "root");//参数名：参考的是数据库的文档
        properties.setProperty("password", "123456");//密码
//        properties.setProperty("useUnicode", "true");//编码
//        properties.setProperty("characterEncoding", "utf8");//确定编码格式
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", properties);

//        方式三
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15?user=root&password=123456");
        System.out.println(conn.getClass().getName());//如果想要知道驱动的具体类型，就这样进行打印
//        3.创建代表SQL语句的对象
        Statement statement = conn.createStatement();

//        4.执行SQL语句
        ResultSet resultSet = statement.executeQuery("select id,name,password,email,birthday from users");
//        5.如果是查询语句，需要遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("id"));//如果想要知道驱动的具体类型，就这样进行打印
            System.out.println(resultSet.getObject("name"));//如果想要知道驱动的具体类型，就这样进行打印
            System.out.println(resultSet.getObject("password"));//如果想要知道驱动的具体类型，就这样进行打印
            System.out.println(resultSet.getObject("email"));//如果想要知道驱动的具体类型，就这样进行打印
            System.out.println(resultSet.getObject("birthday"));//如果想要知道驱动的具体类型，就这样进行打印
        }
//        6.释放占用的资源
        resultSet.close();
        statement.close();
        conn.close();
    }
}
