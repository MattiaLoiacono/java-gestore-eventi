package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	
	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTot);
		this.setOra(ora);
		this.setPrezzo(prezzo);
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) throws Exception {
		if(prezzo.compareTo(new BigDecimal(0)) == -1) {
			throw new Exception("Inserire prezzo positivo");
		}
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	public String oraFormattata() {
		DateTimeFormatter t = DateTimeFormatter.ofPattern("HH:mm");
		return ora.format(t);
	}
	
	public BigDecimal prezzoFormattato() {
		return prezzo.setScale(2,RoundingMode.HALF_EVEN);
	}
	
	@Override
	public String toString() {
		return dataFormattata() + "-" + oraFormattata() + "-" + titolo + "-" + prezzoFormattato() + "€" ;
		
	}
}
