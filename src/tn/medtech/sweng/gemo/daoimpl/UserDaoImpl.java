package tn.medtech.sweng.gemo.daoimpl;
import tn.medtech.sweng.gemo.dao.UserDao;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;
import tn.medtech.sweng.gemo.entities.User;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


   public void insert(User user) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user (firstName,lastName,userName,password, status,email,admin) VALUES(?,?,?,?,?,?,?) ");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getStatus());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setBoolean(7, user.isAdmin());
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


    }


    public void delete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //open connection
            connection= ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setInt(1, id);
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
            preparedStatement = connection.prepareStatement("SELECT  * FROM  user WHERE  userName = ?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUserName(resultSet.getString("userName"));
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


    public List<User> selectAll() {

        List<User> uzers = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT  * FROM user");

            while (resultSet.next()) {
                User uzer = new User();
                uzer.setId(resultSet.getInt("id"));
                uzer.setFirstName(resultSet.getString("firstName"));
                uzer.setLastName(resultSet.getString("lastName"));
                uzer.setUserName(resultSet.getString("userName"));
                uzer.setEmail(resultSet.getString("email"));
                uzer.setPassword(resultSet.getString("password"));
                uzer.setStatus(resultSet.getString("status"));
                uzer.setAdmin(resultSet.getBoolean("admin"));


                uzers.add(uzer);
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

            if (statement != null) {
                try {
                    statement.close();
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


        return uzers;

    }


    public List<String> selectAllNames() {

        //create array list of names

        List<String> names = new ArrayList<String>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT userName FROM user"  );

            while (resultSet.next()){
                String name;

                name = (resultSet.getString("userName"));

                names.add(name);
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
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



        return names;

    }


}
