package tn.medtech.sweng.gemo.daoimpl;

import tn.medtech.sweng.gemo.dao.UserPendingDao;
import tn.medtech.sweng.gemo.entities.UserPending;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserPendingDaoImpl implements UserPendingDao {

   public void insert(UserPending userp){
       Connection connection= null;
       PreparedStatement preparedStatement=null;




           try {
               connection = ConnectionConfiguration.getConnection();
               preparedStatement = connection.prepareStatement("INSERT INTO userpending (firstName, lastName ,userName, status, email, password, admin ) VALUES(?,?,?,?,?,?,?)");
               preparedStatement.setString(1, userp.getFirstName());
               preparedStatement.setString(2, userp.getLastName());
               preparedStatement.setString(3, userp.getUserName());
               preparedStatement.setString(4, userp.getStatus());
               preparedStatement.setString(5, userp.getEmail());
               preparedStatement.setString(6, userp.getPassword());
               preparedStatement.setBoolean(7, userp.isAdmin());

               preparedStatement.executeUpdate();
               System.out.println();
               System.out.println();
               System.out.println("User Pending Account inserted successfully !!");

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




    public UserPending selectById(int id) {


        UserPending userp = new UserPending();
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
        try {
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement( "SELECT  * FROM  userpending WHERE  id = ?" );
            preparedStatement.setInt( 1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                userp.setId(resultSet.getInt("id"));
                userp.setFirstName(resultSet.getString("firstName"));
                userp.setLastName(resultSet.getString("lastName"));
                userp.setUserName(resultSet.getString("userName"));
                userp.setStatus(resultSet.getString("status"));
                userp.setEmail(resultSet.getString("email"));
                userp.setPassword(resultSet.getString("password"));
                userp.setAdmin(resultSet.getBoolean("admin"));

            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null){
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
            if ( conection != null) {
                try {
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return userp;

    }




   public void delete(int id){

       Connection conection = null;
       PreparedStatement preparedStatement = null;


       UserPendingDaoImpl dao = new UserPendingDaoImpl();

       if(dao.checkId(id) >= 0) {

           try {
               //open connection
               conection = ConnectionConfiguration.getConnection();
               preparedStatement = conection.prepareStatement("DELETE FROM userpending WHERE id=?");
               preparedStatement.setInt(1, id);
               preparedStatement.executeUpdate();

               //echo
               System.out.println("User Account Deleted successfully !!");

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

               if (conection != null) {
                   try {
                       conection.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }


           }
       }
       else
       { System.out.println("this Account's id does not exist!");}


   }


   public List<UserPending> selectAll(){

       //create array list of service object

       List<UserPending> usersPs = new ArrayList<>();
       Connection connection = null;
       Statement statement = null;
       ResultSet resultSet = null;

       try {
           connection = ConnectionConfiguration.getConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery( "SELECT  * FROM userpending"  );

           while (resultSet.next()){
               UserPending userp = new UserPending();
               userp.setId(resultSet.getInt("id"));
               userp.setFirstName(resultSet.getString("firstName"));
               userp.setLastName(resultSet.getString("lastName"));
               userp.setUserName(resultSet.getString("userName"));
               userp.setStatus(resultSet.getString("status"));
               userp.setEmail(resultSet.getString("email"));
               userp.setPassword(resultSet.getString("password"));
               userp.setAdmin(resultSet.getBoolean("admin"));


               usersPs.add(userp);
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



       return usersPs;

   }






   public int  checkId(int id){


       int r=-1;
       Connection conection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;  // from java sql package ; resultSet is a table of records from your database
       try {
           conection = ConnectionConfiguration.getConnection();
           preparedStatement = conection.prepareStatement("SELECT  id FROM  userpending WHERE  id = ?");
           preparedStatement.setInt(1, id);
           resultSet = preparedStatement.executeQuery();

           while (resultSet.next()) {
               r=resultSet.getInt("id");
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
           if (conection != null) {
               try {
                   conection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }

       return r;
   }

}
