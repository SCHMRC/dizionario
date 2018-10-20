package it.dizionario.marco.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dizionario.marco.Model.Parola;

public class DizionarioDAO {
	
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/dizionario?user=root&password=LeonardoViola201";
	private static String sql = "SELECT id,nome FROM parola WHERE nome LIKE ? LIMIT 500;";
			
			
	public static List<Parola> searchByName(String cerca) {
		
		List<Parola> risultato = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			PreparedStatement std = conn.prepareStatement(sql);
			std.setString(1, cerca+"%");
			ResultSet res = std.executeQuery();
			while (res.next()) {
				Parola p = new Parola (res.getInt("id"),res.getString("nome"));
				risultato.add(p);
			}
			conn.isClosed();
			return risultato;
	
		} catch (SQLException e) {
			System.err.println("Errore di connessione!");
			return null;
		
		}
		
		
	}
	
}
