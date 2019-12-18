package fx_painting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PaintingQueries {
	
		private static final String URL = "jdbc:derby:painting";
		private static final String USERNAME = "sneha";
		private static final String PASSWORD = "sneha";

		private Connection connection; // manages connection
		private PreparedStatement selectAllPaintings;
		//private PreparedStatement selectRingByMaterial;
		private PreparedStatement insertNewPainting;
		//private PreparedStatement deleteRing;

	// constructor
		public PaintingQueries() {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

				
				selectAllPaintings = connection.prepareStatement("SELECT * FROM painting");

				

				// create insert that adds a new entry into the database
				insertNewPainting = connection.prepareStatement(
						"INSERT INTO painting  (artist, name, paintingyear) VALUES (?, ?,?)");
				
				
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				System.exit(1);
			}
		}
			public List<Painting> getAllPaintings() {
				// executeQuery returns ResultSet containing matching entries
				try (ResultSet resultSet = selectAllPaintings.executeQuery()) {
					List<Painting> results = new ArrayList<Painting>();

					while (resultSet.next()) {
						Painting paintings = new Painting(resultSet.getString("artist"), resultSet.getString("name"),
								resultSet.getInt("paintingyear"));
						
						results.add(paintings);
					}

					return results;
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}

				return null;
			}

	
		// add an entry
			public int addPainting(String artist, String name,int paintingyear) {

				// insert the new entry; returns # of rows updated
				try {
					// set parameters
					insertNewPainting.setString(1,artist);
					insertNewPainting.setString(2, name);
					insertNewPainting.setInt(3, paintingyear);

					return insertNewPainting.executeUpdate();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
					return 0;
				}
			}
}
