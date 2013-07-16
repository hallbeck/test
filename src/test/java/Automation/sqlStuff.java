package Automation;

/**
 * User: KHALLBEC
 * Date: 7/1/13
 * Time: 10:46 AM
 */
import java.sql.*;

public class sqlStuff
{
    public static void main(String args[]){

         String toPrint=System.getProperty("java.classpath");
        System.out.println("blah_____ "+toPrint);
        String dbtime;
        String dbUrl = "jdbc:mysql://dr0-sql-52/800contacts";
        String dbClass = "com.mysql.jdbc";
        String query = "Select * FROM lens";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection (dbUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
            } //end while

            con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }

    }  //end main
}
/*
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

     */
/*
          Display the driver properties, database details
     *//*


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
*/
