package helper.dboperations;
import utils.TestRunConfig;
import java.sql.*;
public class DbManager {
   static Connection connection;
    static
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             connection = DriverManager.getConnection(TestRunConfig.DATASOURCE_URL);
        } catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void retriveTestResults(String featurename, String scenarioName, String environment) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        StringBuilder policynumber = new StringBuilder();
        try
        {
            String query = String.format("select top 1 [DataValue] from [dbo].[TestResultsData] where " + "[DataKey]='PolicyNumber' and [IsUsed]=0 and [Environment]='%s' and [ScenarioName]='%s' and [FeatureName]='%s'", environment, scenarioName, featurename);
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
               policynumber.append(rs.getString("DataValue"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        } finally
        {
            connection.close();
        }
        System.out.println(policynumber);
    }
    public static void insertTestResults(String featurename, String scenarioname, String environment,String policynumber2) throws ClassNotFoundException, SQLException
    {
        String policynumber=policynumber2;
        try
        {
            String query= String.format("INSERT INTO [dbo].[TestResultsData] ([FeatureName], [ScenarioName], [Environment], [DataKey], [DataValue], [IsUsed], [DateCreated], [DateUsed]) " +
                            "VALUES ('%s', '%s', '%s', 'PolicyNumber', '%s', 0,GETDATE(),GETDATE())",
                            featurename, scenarioname, environment, policynumber);
            Statement stat =connection.createStatement();
            int rs = stat.executeUpdate(query);
        }
        catch(Exception e)
        {
           System.out.println(e.getMessage());
        }
        finally
        {
            connection.close();
        }
    }


    public static void updateTestResults(String policynumber, String featureName, String scenarioName, String environment) throws  SQLException
    {
        String policyNumber=null;
        try
        {
            String Query=String.format("update [dbo].[TR_DCODQA] set [IsUsed]=1, [DateUsed]=GETDATE() " +
                            "where [DataValue]='%s' and [IsUsed]=0 and [Environment]='%s' and [ScenarioName]='%s' and [FeatureName]='%s'",
                    policynumber, environment, scenarioName, featureName);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            connection.close();
        }
    }
    public static void main(String[]args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        DbManager db=new DbManager();
        retriveTestResults("Feature1","Scenario1","Production");
        insertTestResults("","","","");
    }



}


