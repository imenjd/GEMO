package tn.medtech.sweng.gemo.daoimpl;

import tn.medtech.sweng.gemo.dao.ServiceDao;
import tn.medtech.sweng.gemo.entities.Service;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public void insert(Service service) {

        Connection connection= null;
        PreparedStatement preparedStatement=null;

        try{
            connection= ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO service (id,name) VALUES(?,?)");
            preparedStatement.setInt(1,service.getId());
            preparedStatement.setString(2,service.getName());
            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();

            System.out.println("inserted successfully !!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }





    }

    @Override
    public void update(Service service, String name) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;


        try {
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE service SET name=? WHERE name=?");
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2,name );
            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();
            System.out.println("updated successfully !! ");
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Override
    public void delete(String name) {

        Connection conection = null;
        PreparedStatement preparedStatement = null;

        try {
            //open connection
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement("DELETE FROM service WHERE name=?");
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();

            //echo
            System.out.println("DELETE FROM service WHERE name=?");

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
    public Service selectByName(String name) {

        Service service = new Service();
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
        try {
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement( "SELECT  * FROM  service WHERE  name = ?" );
            preparedStatement.setString( 1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                service.setId( resultSet.getInt("id"));
                service.setName(resultSet.getString("name"));

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

        return service;



    }

    @Override
    public Service selectById(int id) {


        Service service = new Service();
        Connection conection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
        try {
            conection = ConnectionConfiguration.getConnection();
            preparedStatement = conection.prepareStatement( "SELECT  * FROM  service WHERE  id = ?" );
            preparedStatement.setInt( 1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                service.setId( resultSet.getInt("id"));
                service.setName(resultSet.getString("name"));

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

        return service;

    }

    @Override
    public List<Service> selectAll() {
        return null;
    }
}
