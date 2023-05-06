import java.sql.*;
public class Metadata
{
	public static void main(String args[])
	{	try{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://server2/exam1","exam1","exam1");
		DatabaseMetaData dbmd=con.getMetaData();
		System.out.println("\t-------------------------------------------");
		System.out.println("\t\tDriver Name : "+dbmd.getDriverName());
		System.out.println("\t\tDriver Version : "+dbmd.getDriverVersion());
		System.out.println("\t\tUserName : "+dbmd.getUserName());
		System.out.println("\t\tDatabase Product Name : "+dbmd.getDatabaseProductName());
		System.out.println("\t\tDatabase Product Version : "+dbmd.getDatabaseProductVersion());
		System.out.println("\t--------------------------------------------");
		
		String table[]={"TABLE"};
		ResultSet rs=dbmd.getTables(null,null,null,table);
		System.out.println("\t\tTable Names ");
		while(rs.next())
		{
			System.out.println(rs.getString("TABLE_NAME"));
			}
		rs.close();
		con.close();
	}
	catch(Exception e){
	System.out.println(e);
	}
	}
}		
