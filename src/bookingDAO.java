import java.util.Date;
import java.sql.*;
public class bookingDAO {
    public int getBookingCount(int busno, Date date) throws Exception {
        String query="select count(passenger_name) from booking where  bus_no =? and travel_date=?";
        Connection con=DbConnection.getConnection();
        PreparedStatement pst= con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,busno);
        pst.setDate(2,sqldate);
        ResultSet rst=pst.executeQuery();
        rst.next();
        return rst.getInt(1);
    }

    public void addBooking(Booking booking)throws Exception{
        Connection con=DbConnection.getConnection();
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        String query="Insert into booking values(?,?,?)";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqldate);
        pst.executeUpdate();

    }
}
