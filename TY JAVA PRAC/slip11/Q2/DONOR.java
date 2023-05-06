import java.sql.*;
public class DONOR{
public static void main(String args[])
{	
	try{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://server2/exam1","exam1","exam1");
	Statement stmt=null;
	stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from donor");
	ResultSetMetaData rsmd=rs.getMetaData();
	System.out.println("\t-----------------------------------------------");
	int count=rsmd.getColumnCount();
	System.out.println("\t No. of Columns : "+rsmd.getColumnCount());
	System.out.println("\t-----------------------------------------------");
	for(int i=1;i<=count;i++)
	{
		System.out.println("\t\tColumn No : "+i);
		System.out.println("\t\tColumn Name : "+rsmd.getColumnName(i));
		System.out.println("\t\tColumn Type : "+rsmd.getColumnTypeName(i));
		System.out.println("\t\tColumn Size : "+rsmd.getColumnDisplaySize(i));
		System.out.println();
	}
	System.out.println("\t-----------------------------------------------");
	con.close();
	}catch(Exception e)
	{
		System.out.println(e);	
	}
	}
}

	
	
