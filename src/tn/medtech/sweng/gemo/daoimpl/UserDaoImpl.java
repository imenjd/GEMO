package tn.medtech.sweng.gemo.daoimpl;
import tn.medtech.sweng.gemo.dao.UserDao;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;
import tn.medtech.sweng.gemo.entities.User;

import java.sql.Connection;
import java.sql.*;

public class UserDaoImpl implements UserDao {


   public void insert(User user) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user (last_name,username,Email,password,first_name) VALUES(?,?,?,?,?) ");

            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getFirstName());

            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Inserted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void update(User user, String userName) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE user SET name=? WHERE name=?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();
            System.out.println("updated successfully !! ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void delete(String name) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //open connection
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE name=?");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("DELETE FROM user WHERE name=?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }


    }
  
    public User selectByUserName(String userName) {
      
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  * FROM  user WHERE  username = ?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return user;
   }
}
