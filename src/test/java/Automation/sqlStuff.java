package Automation;

import java.sql.Driver;

/**
 * User: KHALLBEC
 * Date: 7/1/13
 * Time: 10:46 AM
 */
public class sqlStuff {
    private java.sql.Connection  con = null;
    private final String url = "jdbc:microsoft:sqlserver://";
    private final String serverName= "dr0-sql-52";
    private final String portNumber = "1433";
    private final String databaseName= "1800Contacts";
    private final String userName = "khallbec";
    private final String password = "Card.bus4";
    // Informs the driver to use server a side-cursor,
    // which permits more than one active statement
    // on a connection.
    private final String selectMethod = "cursor";


    // Constructor
    public sqlStuff(){}

    private String getConnectionUrl(){
        return url+serverName+":"+portNumber+";databaseName="+databaseName+";selectMethod="+selectMethod+";";
    }

    private java.sql.Connection getConnection(){
        try{
            Driver d = (Driver)Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            //Class.forName
                    //("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(getConnectionUrl(),userName,password);
            if(con!=null) System.out.println("Connection Successful!");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return con;
    }

     /*
          Display the driver properties, database details
     */

    public void displayDbProperties(){
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet rs = null;
        try{
            con= this.getConnection();
            if(con!=null){
                dm = con.getMetaData();
                System.out.println("Driver Information");
                System.out.println("\tDriver Name: "+ dm.getDriverName());
                System.out.println("\tDriver Version: "+ dm.getDriverVersion ());
                System.out.println("\nDatabase Information ");
                System.out.println("\tDatabase Name: "+ dm.getDatabaseProductName());
                System.out.println("\tDatabase Version: "+ dm.getDatabaseProductVersion());
                System.out.println("Avalilable Catalogs ");
                rs = dm.getCatalogs();
                while(rs.next()){
                    System.out.println("\tcatalog: "+ rs.getString(1));
                }
                rs.close();
                rs = null;
                closeConnection();
            }else System.out.println("Error: No active Connection");
        }catch(Exception e){
            e.printStackTrace();
        }
        dm=null;
    }

    private void closeConnection(){
        try{
            if(con!=null)
                con.close();
            con=null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception
    {
        sqlStuff myDbTest = new sqlStuff();
        myDbTest.displayDbProperties();
    }
}
