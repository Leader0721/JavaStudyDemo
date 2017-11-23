package day16jdbc;

import day15jdbc01.utils.JDBCUtils;
import jdk.internal.util.xml.impl.Input;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 大数据的存储
 * <p>
 * create table t2(
 * id int primary key,
 * content longtext);
 * <p>
 * Created by 83731 on 2017/09/17.
 */
public class LobDemo {
    @Test
    public void test1() {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into t2 values(?,?)");
            statement.setInt(1, 1);

            File file = new File("src/jpm.txt");
            Reader reader = new FileReader(file);

            //用流的方式
//            statement.setCharacterStream(2, reader, file.length());
            statement.setCharacterStream(2, reader, (int) file.length());//强转成int型就可以了

            //prepareStatement的实现是由数据库驱动提供的
            //   MySQL:setCharacter(int,Reader,long);这个方法没有被实现  long类型的是2的64次方
            //MySQL无法支持那么大的数据  longtext最大支持2的32次方      但是其他的数据库可以支持  oracle可以支持


            statement.executeUpdate();

            JDBCUtils.release(null, statement, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test2() {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from t2 where id =1");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Reader reader = resultSet.getCharacterStream("content");
                int len = -1;
                //将内容进行一个保存
                Writer w = new FileWriter("d:/1.txt");
                char c[] = new char[1024];
                while ((len = reader.read(c)) != -1) {
                    w.write(new String(c), 0, len);
                }
                reader.close();
                w.close();
            }


            JDBCUtils.release(null, statement, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 二进制的
     * <p>
     * create table t3(
     * id int primary key,
     * content longblob);
     */
    @Test
    public void test3() {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into t3 values(?,?)");
            statement.setInt(1, 2);
            InputStream in = new FileInputStream("src/maple.jpg");


            statement.setBinaryStream(2, in, in.available());
            statement.executeUpdate();
            JDBCUtils.release(null, statement, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test4() {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from t3 where id =1");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                InputStream in = resultSet.getBinaryStream("content");
                OutputStream outputStream = new FileOutputStream("d:/wife.jpg");
                int len = -1;
                byte b[] = new byte[1024];
                while ((len = in.read(b)) != -1) {
                    outputStream.write(b, 0, len);

                }
                in.close();
                outputStream.close();
            }
            JDBCUtils.release(null, statement, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
