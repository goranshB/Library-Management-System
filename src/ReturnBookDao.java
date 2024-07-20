import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBookDao {
	public static int delete(String bookcallno,int studentid,String newdate){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
                
			status=updatebook(bookcallno);
                        //updating quantity and issue
                        ffine(newdate,studentid);
			
			if(status>0){
			PreparedStatement ps=con.prepareStatement("delete from issuebooks where bookcallno=? and studentid=?");
			ps.setString(1,bookcallno);
			ps.setInt(2,studentid);
			status=ps.executeUpdate();
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int updatebook(String bookcallno){
		int status=0;
		int quantity=0,issued=0;
		try{
			Connection con=DB.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(issued>0){
			PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,bookcallno);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        /*public static int ffine(String newdatee,int studentid){
		int status=0;
		Date quantity;
		try{
			Connection con=DB.getConnection();
			
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date newdate = dateFormat.parse(newdatee);
                        
                        
			PreparedStatement ps=con.prepareStatement("select issueddate from issuebooks where studentid=?");
			ps.setInt(1,studentid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getDate("issueddate");
				//issued=rs.getInt("issued");
			}
                        long diffInMillies = Math.abs(newdate.getTime() - quantity.getTime());
                        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
                        if((((int) diffInDays)-15) <= 0){
                                  diffInDays = 0;
                        }
                        else{
                             diffInDays = diffInDays - 15 ;
                        }
                        
			
			
			PreparedStatement ps2=con.prepareStatement("insert into charge(fine) values(?)");
			ps2.setInt(1,(int)diffInDays);
			
			
			status=ps2.executeUpdate();
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        */
 public static int ffine(String newdatee, int studentid) {
    int status = 0;
    Date quantity = null; // Initialize the Date variable
    try {
        Connection con = DB.getConnection();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newdate = dateFormat.parse(newdatee);

        // Retrieve the issueddate for the given studentid
        PreparedStatement ps = con.prepareStatement("SELECT issueddate FROM issuebooks WHERE studentid=?");
        ps.setInt(1, studentid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            quantity = rs.getDate("issueddate");
        }

        // Calculate the difference in days and apply the fine logic
        if (quantity != null) {
            long diffInMillies = Math.abs(newdate.getTime() - quantity.getTime());
            long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);

            if ((int) diffInDays > 15) {
                diffInDays =diffInDays - 15; // Subtract 15 days from the difference
            } else {
                diffInDays = 0; // No fine if less than or equal to 15 days
            }
            diffInDays *= 5;
            // Insert the fine into the charge table
            PreparedStatement ps2 = con.prepareStatement("INSERT INTO charge (fine) VALUES (?)");
            ps2.setInt(1, (int) diffInDays);
            

            status = ps2.executeUpdate();
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace(); // print the exception for debugging
    }
    return status;
}

}
