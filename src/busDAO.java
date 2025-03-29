import java.sql.*;
public class busDAO {
  public void  displayBusInfo() throws Exception{
      String query="Select * from bus";
      Connection con=DbConnection.getConnection();
      Statement st=con.createStatement();
      ResultSet rst=st.executeQuery(query);
      while(rst.next()){
          System.out.println("BUS NO:"+rst.getInt(1));
          if(rst.getInt(2)==0)
              System.out.println("AC:NO");
          else
              System.out.println("AC: YES");
          System.out.println("Capacity:" +rst.getInt(3));
      }
      System.out.println("_________________________");
  }
    public int getCapacity(int id)throws Exception{
      String query=" select capacity from bus where id="+id;
      Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rst=st.executeQuery(query);
        rst.next();
        return rst.getInt(1);



    }



}
