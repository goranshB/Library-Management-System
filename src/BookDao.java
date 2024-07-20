import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
        int issued = 0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into books (callno,name,author,publisher,quantity,issued) values(?,?,?,?,?,?)");
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
                ps.setInt(6,0);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
/*public static int update(String callnoo,String namee,String authorr,String publisherr,int quantityy){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE books SET name = namee , author = authorr , publisher = publisherr , quantity = quantityy WHERE callno = callnoo ");
		ps.setString(1,callnoo);
		ps.setString(2,namee);
		ps.setString(3,authorr);
		ps.setString(4,publisherr);
		ps.setInt(5,quantityy);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
*/

}


