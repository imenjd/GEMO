package tn.medtech.sweng.gemo.daoimpl;

import tn.medtech.sweng.gemo.dao.DciDao;
import tn.medtech.sweng.gemo.entities.Dci;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DciDaoImpl implements DciDao {


    public void insert(Dci dci) {

        Connection connection= null;
        PreparedStatement preparedStatement=null;

        try{
            connection= ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO dci (id,name) VALUES(?,?)");
            preparedStatement.setInt(1,dci.getId());
            preparedStatement.setString(2,dci.getName());
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


    public void update(Dci dci, int id) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;


        try {
            connection= ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE dci SET id=? , name=? WHERE id=?");
            preparedStatement.setInt(1, dci.getId());
            preparedStatement.setString(2, dci.getName() );
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


        DciDaoImpl dao = new DciDaoImpl();

        if(dao.checkId(id) >= 0) {

            try {

                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("DELETE FROM dci WHERE id=?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();


                System.out.println("Dci Deleted successfully!!");

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
        else
        { System.out.println("this id does not exist!");}



    }


    public Dci selectByName(String name) {

        Dci dci = new Dci();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement( "SELECT  * FROM  dci WHERE  name = ?" );
            preparedStatement.setString( 1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                dci.setId( resultSet.getInt("id"));
                dci.setName(resultSet.getString("name"));

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

        return dci;



    }


    public Dci selectById(int id) {


        Dci dci = new Dci();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement( "SELECT  * FROM  dci WHERE  id = ?" );
            preparedStatement.setInt( 1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                dci.setId( resultSet.getInt("id"));
                dci.setName(resultSet.getString("name"));

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

        return dci;

    }


    public List<Dci> selectAll() {


        List<Dci> dcis = new ArrayList<Dci>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery( "SELECT  * FROM dci"  );

            while (resultSet.next()){
                Dci dci = new Dci();
                dci.setId(resultSet.getInt("id"));
                dci.setName(resultSet.getString("name"));

                dcis.add(dci);
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



        return dcis;

    }


    public int  checkId(int id) {

        int x=-1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  id FROM  dci WHERE  id = ?");
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

