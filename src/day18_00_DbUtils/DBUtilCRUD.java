package day18_00_DbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import util.DBCPUtil;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import java.io.*;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by 83731 on 2017/10/27.
 * <p>
 * create database day18;
 * use day18;
 * create table student(
 * id int primary key,
 * name varchar(100),
 * birthday date
 * );
 * <p>
 * <p>
 * }
 */
public class DBUtilCRUD {
    private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

    @Test
    public void testAdd() throws SQLException {
        queryRunner.update("insert into student values(?,?,?)", 2323, "yangyang", new Date());
    }

    @Test
    public void testUpdate() throws SQLException {
        queryRunner.update("update student set birthday = ? where id = ?", "1993-03-01", 1);
    }

    @Test
    public void testDelete() throws SQLException {
        queryRunner.update("delete from student where id = ?", 1);
    }

    @Test
    public void testBatch() throws SQLException {
        Object params[][] = new Object[10000][];//高维:记录的条数  低维：每条记录所需的参数

        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{i + 1, "杨洋" + (i + 1), new Date()};
        }
        queryRunner.batch("insert into student values(?,?,?)", params);
    }

    //大文本 提供了解

    /**
     * create table t1(
     * id int primary key,
     * content longtext
     * );
     */
    @Test//大文本类型对应   Clob类型
    public void testClob() throws Exception {
//        src\day18_00_DbUtils\big
        File file = new File("src/day18_00_DbUtils/big");
        Reader reader = new FileReader(file);
        char ch[] = new char[(int) file.length()];

        //将数据读到ch之中，然后往数据库中传输
        reader.read(ch);
        reader.close();

        Clob clob = new SerialClob(ch);
        queryRunner.update("insert into t1 values(?,?)", 223, clob);//如果直接运行，报错，运行不匹配
    }

    /**
     create table t3(
     id int primary key,
     content longblob
     );
     */
    //大二进制  提供了解
    @Test//大文本类型对应   Clob类型
    public void testBlob() throws Exception {
        InputStream in = new FileInputStream("src/day18_00_DbUtils/model.png");
        byte[] b = new byte[in.available()];
        in.read(b);
        in.close();
        Blob blob = new SerialBlob(b);
        queryRunner.update("insert into t3 values(?,?)", 223, blob);//如果直接运行，报错，运行不匹配
    }
}
