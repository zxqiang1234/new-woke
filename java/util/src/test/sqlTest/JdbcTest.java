package test.sqlTest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2018-10-30 14:36
 **/
public class JdbcTest {

    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            DriverManager.getConnection("","","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
                   dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                   dataSource.setUrl("jdbc\\:sqlserver\\://117.34.91.90\\:1433;databaseName\\=imp_pd");
                   dataSource.setUsername("root");
                   dataSource.setPassword("public*963.");

                   // 创建JDBC模板
                   JdbcTemplate jdbcTemplate = new JdbcTemplate();
                   // 这里也可以使用构造方法
                   jdbcTemplate.setDataSource(dataSource);

                   // sql语句
                   String sql = "select count(*)  from user";
//        Long num = null;
//        try {
//            num = (long) jdbcTemplate.queryForObject(sql, Long.class);
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }

//        System.out.println(num);

               }
}
