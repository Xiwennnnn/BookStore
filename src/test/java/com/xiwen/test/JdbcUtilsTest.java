package com.xiwen.test;

import com.xiwen.pojo.User;
import com.xiwen.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        Connection connection = null;

        //3.执行SQL
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<User> userArrayList = new ArrayList<>();
        String sql = "SELECT * FROM t_user " +
                "WHERE `id` >= ?;";

        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                userArrayList.add(new User(id, name, password, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            JdbcUtils.close(connection);
        }

        //关闭Connection后，轻松调用集合
        System.out.println("List = " + userArrayList);
        System.out.println("===================================");

        for (int i = 0; i < userArrayList.toArray().length; i++) {
            System.out.print("id = " + userArrayList.get(i).getId());
            System.out.print("\tname = " + userArrayList.get(i).getUsername());
            System.out.println();
        }


    }
}
