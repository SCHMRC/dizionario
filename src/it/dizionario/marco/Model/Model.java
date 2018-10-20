package it.dizionario.marco.Model;


import java.util.List;

import it.dizionario.marco.DAO.DizionarioDAO;

public class Model {
	public Model() {
		super();
	}
	
	public List<Parola> search(String cerca){
		return DizionarioDAO.searchByName(cerca);
	}
	

}
