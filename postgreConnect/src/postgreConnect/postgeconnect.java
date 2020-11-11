package postgreConnect;
import java.sql.*;
import java.util.*;

public class postgeconnect {

	public static List<String> Connect(int pagenum) {

		List<String> films = new ArrayList<String>();
		
		String username = "masterUsername";
		String password = "boohoo53";
		String dbName = "myDatabase";
		//The following is how to do the connection URL bit
		//hostname is the endpoint url in java
		//jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password
		String jdbcURL = "jdbc:postgresql://rds-postgressql-10mintutorial.cw589ckbkibf.us-east-2.rds.amazonaws.com:5432/" +
						dbName + "?user=" + username + "&password=" + password;
		
		try {
			//establishes the connection to the database
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			//just tells you that the connection has been established, will probably want to take this out
			System.out.println("Connected to " + dbName);
			//the next 3 lines are the SQL statement and the code that query the server
			//the query here will grab a list of all unique film names in database(no repeats) and return a limited amount
			//will move through the database based on a passed in page number so that there are not a crap ton of films being thrown over
			String sql = "SELECT DISTINCT film FROM kaggle_data ORDER BY film LIMIT 12 OFFSET " + (pagenum - 1)*12;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			//puts the title of each film in a String list
			while(rs.next()) {
				films.add(rs.getString("film"));
			}
			//closes the connection to the database
			connection.close();
		//if there is a SQL error this next bit will throw the error at you and stop the connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//returns the string list of the film titles based on page number
		return films;
	}
	
	public static void main(String[]args) {
		System.out.println(Connect(1));
	}
}