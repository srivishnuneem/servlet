import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connectivity{

	static PreparedStatement ps;
	static ResultSet rs;
	
	public static boolean login(String name, String pass) {
		boolean states = false;
		try {
			ps = getConnection().prepareStatement("select * from crudtable where userName=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			rs = ps.executeQuery();  
			states =  rs.next();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return states;
	}
	
	public static boolean register(String n,String u,String p,String m,String gmail,String date,String gender,String addess,String pla,String l,String q) {
		boolean states = false;
		try {
			ps = getConnection().prepareStatement("insert into crudtable (`name`,`mobile`,`gender`,`plase`,`language`,`qulification`,`gmail`,`birthDay`,`address`,`userName`,`password`)value(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, n);
            ps.setString(2,m);
            ps.setString(3,gender);
            ps.setString(4,pla);
            ps.setString(5,l);
            ps.setString(6,q);
            ps.setString(7,gmail);
            ps.setString(8,date);
            ps.setString(9,addess);
            ps.setString(10,u);
            ps.setString(11,p);
            if(ps.executeUpdate()>0){
                states=true;
            }
		} catch (Exception e) {
			System.out.println(e);
		}
		return states;
	}
	
	public static boolean update(String a) {
		boolean states = false;
		try {
			ps=getConnection().prepareStatement("select * from `crudtable` where `a`=?");
			ps.setString(1, "userName");
			rs=ps.executeQuery();
			states=rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return states;
	}
	
	public static String[] fach(String user) {
		String temp []=new String [11]; 
		try {
			ps=getConnection().prepareStatement("select * from `crudtable` where `user`=?");
			temp[0]=rs.getString("name");
			temp[1]=rs.getString("userName");
			temp[2]=rs.getString("password");
			temp[3]=rs.getString("mobile");
			temp[4]=rs.getString("gender");
			temp[5]=rs.getString("plase");
			temp[6]=rs.getString("language");
			temp[7]=rs.getString("qulification");
			temp[8]=rs.getString("gmail");
			temp[9]=rs.getString("birthDay");
			temp[10]=rs.getString("address");
		} catch (Exception e) {
			System.out.println(e);
		}
		return temp;
		}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/crud","root","vishnu@123");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}