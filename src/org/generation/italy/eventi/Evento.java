package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTot, postiPrenotati;
	
	public Evento(String titolo, LocalDate data, int postiTot) throws Exception {
		this.setTitolo(titolo);
		this.setData(data);
		if(postiTot > 0) {
			this.postiTot = postiTot;
		}else {
			throw new Exception("Il numero dei posti deve essere positivo");
		}
		this.postiPrenotati = 0;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		if(isValidData(data)) {
			this.data = data;
		}else {
			throw new Exception("Impossibile inserire una data già passata");
		}
	}

	public int getPostiTot() {
		return postiTot;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	private boolean isValidData(LocalDate data) {
		return data.isAfter(LocalDate.now());
	}
	
	public void prenota() throws Exception {
		if(isValidData(data)) {
			postiPrenotati++;
		}else {
			throw new Exception("Impossibile prenotare per un evento passato");
		}
	}
	
	public void disdici() throws Exception {
		if(isValidData(data)) {
			if (postiPrenotati > 0) {
				postiPrenotati--;
			}else {
				throw new Exception("Impossibile disdire se non ci sono posti prenotati");
			}
		}else {
			throw new Exception("Impossibile disdire per un evento passato");
		}
	}
	
	@Override
	public String toString() {
		return dataFormattata() + "-" + titolo;
	}
	
	private String dataFormattata() {
		DateTimeFormatter t = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return  data.format(t);
	}
}
