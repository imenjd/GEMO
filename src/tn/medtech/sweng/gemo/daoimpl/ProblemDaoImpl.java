package tn.medtech.sweng.gemo.daoimpl;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import tn.medtech.sweng.gemo.dao.ProblemDao;
import tn.medtech.sweng.gemo.entities.Problem;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

public class ProblemDaoImpl implements ProblemDao {


    public ProblemDaoImpl() {
    }

    @Override
    public void insert(Problem problem) {

        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(" INSERT INTO  problem (id ,name) VALUES (? , ?);   ");
            preparedStatement.setInt(1, problem.getId());
            preparedStatement.setString(2 , problem.getName());
            preparedStatement.executeUpdate();
            System.out.println( "insert done !");

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }



    @Override
    public void delete(int id) {

        Connection conection = null;
        PreparedStatement preparedStatement = null;

        try {
            //open connection
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement("DELETE FROM problem WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            //echo
            System.out.println("DELETE done");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conection != null){
                try {
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

    }


    @Override

    public void update(Problem problem, int id) {


        Connection conection = null;
        PreparedStatement preparedStatement = null;

        try {
            //open connection
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement(" UPDATE problem SET name=?   WHERE  id=?");
            preparedStatement.setString(1, problem.getName());
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();

            //echo
            System.out.println("updated");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conection != null){
                try {
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }


    }

    public List<Problem> selectAll() {

        //create array list of service object

        List<Problem> services = new ArrayList<Problem>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT  * FROM problem"  );

            while (resultSet.next()){
                Problem service = new Problem();
                service.setId(resultSet.getInt("id"));
                service.setName(resultSet.getString("name"));

                services.add(service);
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



        return services;

    }


}