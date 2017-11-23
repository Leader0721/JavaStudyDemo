package day18_00_DbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import util.DBCPUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by 83731 on 2017/10/27.
 */
public class ResultSetHandlerDemo {
    private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());


    //ArrayHandler:适合结果只有一条的情况 把第一条记录的每列的值封装到一个Object[]数组中
    @Test
    public void test1() throws Exception {
        Object[] objects = queryRunner.query("select * from student", new ArrayHandler());
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    //ArrayListHandler:适合结果多條的情况 把每列的值封裝到Object[]数组中 把Object[]放到List中
    @Test
    public void test2() throws Exception {
        List<Object[]> objects = queryRunner.query("select * from student", new ArrayListHandler());
        for (Object[] object : objects) {
            for (Object o : object) {
                System.out.println(o);
            }
        }

    }

    //ColumnListHandler:适合取某列的值  把取到的值封裝到Object[]数组中 把Object[]放到List中
    @Test
    public void test3() throws Exception {
        List<Object> objects = queryRunner.query("select * from student", new ColumnListHandler("name"));
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    //KeyedHandler:查询多条记录  每条记录封装到一个Map中，key字段名，value：字段值。再把Map作为value放到另外一个Map中，该map的key为指定的列值作为key
    @Test
    public void test4() throws Exception {
        Map<Object, Map<String, Object>> objectMapMap = queryRunner.query("select * from student", new KeyedHandler("id"));
        for (Map.Entry<Object, Map<String, Object>> bme : objectMapMap.entrySet()) {
            System.out.println("----------------------------------------");
            for (Map.Entry<String, Object> lme : bme.getValue().entrySet()) {
                System.out.println(lme.getKey() + "=" + lme.getValue());
            }
        }
    }

    //MapHandler:适合一条结果  封装到一个Map中，key字段名，value：字段值。
    @Test
    public void test5() throws Exception {
        Map<String, Object> objectMapMap = queryRunner.query("select * from student", new MapHandler());
        System.out.println("----------------------------------------");
        for (Map.Entry<String, Object> lme : objectMapMap.entrySet()) {
            System.out.println(lme.getKey() + "=" + lme.getValue());
        }
    }


    //MapListHandler:适合多条结果  把每条封装到一个Map中，key:字段名，value:字段值，再把Map封装到List中
    @Test
    public void test6() throws Exception {
        List<Map<String, Object>> objectMapMap = queryRunner.query("select * from student", new MapListHandler());
        System.out.println("----------------------------------------");
        for (Map<String, Object> map : objectMapMap) {
            for (Map.Entry<String, Object> lme : map.entrySet()) {
                System.out.println(lme.getKey() + "=" + lme.getValue());
            }
        }

    }

    //ScalarHandler :适合取结果只有一行和一列的情况
    @Test
    public void test7() throws Exception    {
        Object o = queryRunner.query("select count(*) from student", new ScalarHandler(1));
        Long l = (Long) o;
        System.out.print(l.intValue());
        System.out.println(o);

    }


}
