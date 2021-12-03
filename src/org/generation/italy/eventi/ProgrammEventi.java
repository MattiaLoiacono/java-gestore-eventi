package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
	}
	
	public void addEvento(Evento x) {
		this.eventi.add(x);
	}
	
	public List<Evento> eventiData(LocalDate data){
		List<Evento> lista = new ArrayList<Evento>();
		for(Evento y : eventi) {
			if(data.isEqual(y.getData())) {
				lista.add(y);
			}
		}
		return lista;
	}
	
	public int quantiEventi() {
		return eventi.size();
	}
	
	public void svuotaLista() {
		eventi.clear();
	}
	
	public void mostraLista() {
		System.out.println(titolo);
		
		Collections.sort(eventi);
		
		for(Evento x: eventi) {
			System.out.println(x.toString());
		}
		
	}



	

	



	
	
	


	
}
