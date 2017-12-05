package tn.medtech.sweng.gemo.daoimpl;

import tn.medtech.sweng.gemo.dao.MedDao;
import tn.medtech.sweng.gemo.entities.Med;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedDaoImpl implements MedDao  {


    public void insert(Med med)  {

        Connection connection= null;
        PreparedStatement preparedStatement=null;

        try{
            connection= ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO med (id,name) VALUES(?,?)");
            preparedStatement.setInt(1,med.getId());
            preparedStatement.setString(2,med.getName());
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


    public void update(Med med, int id) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;


        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE med SET id=? , name=? WHERE id=?");
            preparedStatement.setInt(1, med.getId());
            preparedStatement.setString(2, med.getName() );
            preparedStatement.setInt(3 , id);
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


    public void delete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM med WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


            System.out.println("DELETE FROM med WHERE name=?");

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

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }




    }


    public Med selectByName(String name) {

        Med med = new Med();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement( "SELECT  * FROM  med WHERE  name = ?" );
            preparedStatement.setString( 1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                med.setId( resultSet.getInt("id"));
                med.setName(resultSet.getString("name"));

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
            if ( connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return med;



    }


    public Med selectById(int id) {


        Med med = new Med();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement( "SELECT  * FROM  med WHERE  id = ?" );
            preparedStatement.setInt( 1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                med.setId( resultSet.getInt("id"));
                med.setName(resultSet.getString("name"));

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
            if ( connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return med;

    }


    public List<Med> selectAll() {



        List<Med> meds = new ArrayList<Med>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT  * FROM med"  );

            while (resultSet.next()){
                Med med = new Med();
                med.setId(resultSet.getInt("id"));
                med.setName(resultSet.getString("name"));

                meds.add(med);
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



        return meds;

    }

    public int  checkId(int id) {

        int x=-1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  id FROM  med WHERE  id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                x=resultSet.getInt("id");
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

        return x;
    }
}
