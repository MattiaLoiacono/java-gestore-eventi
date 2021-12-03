package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			/*
			System.out.print("Inserire il titolo dell'evento: ");
			String titolo = scan.nextLine();
			DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.print("Inserire la data dell'evento: (dd/MM/yyyy)");
			LocalDate data = LocalDate.parse(scan.nextLine(), f);
			System.out.print("Inserire i posti totali dell'evento: ");
			int postiTot = scan.nextInt();
			int postiDisponibili = postiTot;  
			
			
			Evento x = new Evento(titolo, data, postiTot);
			System.out.println(x.toString());
		
			
			System.out.print("Quanti biglietti vuoi prenotare? ");
			int prenotazioni = scan.nextInt();
			if(prenotazioni >= 0 && prenotazioni <= postiDisponibili) {
				for(int i=0; i < prenotazioni; i++) {
					x.prenota();
				}
				postiDisponibili -= prenotazioni;  
			}else if(prenotazioni >= 0 && prenotazioni > postiDisponibili){
				throw new Exception("Impossibile prenotare un numero di biglietti maggiore della disponibilità");
			}else {
				throw new Exception("Impossibile prenotare un numero negativo di biglietti");
			}
			
			System.out.println("Posti prenotati: " + x.getPostiPrenotati());
			System.out.println("Posti disponibili: " + postiDisponibili);
			
			
			System.out.print("Quanti biglietti vuoi disdire? ");
			int disdette = scan.nextInt();
			if(disdette >= 0 && disdette <= prenotazioni) {
				for(int i=0; i < disdette; i++) {
					x.disdici();
				}
				postiDisponibili += disdette;  
			}else if(disdette >= 0 && disdette > prenotazioni){
				throw new Exception("Impossibile disdire un numero di biglietti maggiore delle prenotazioni effettuate");
			}else {
				throw new Exception("Impossibile disdire un numero negativo di biglietti");
			}
			
			System.out.println("Posti prenotati: " + x.getPostiPrenotati());
			System.out.println("Posti disponibili: " + postiDisponibili);
			
			*/
			
			ProgrammEventi programma = new ProgrammEventi("concerti 2022");
			programma.addEvento(new Evento("Pinco", LocalDate.parse("2022-04-12"), 123));
			programma.addEvento(new Evento("Pallo", LocalDate.parse("2022-02-12"), 123));
			programma.addEvento(new Evento("Lillo", LocalDate.parse("2022-05-12"), 123));
			programma.addEvento(new Evento("Ciccio", LocalDate.parse("2022-03-12"), 123));
			
			
			programma.mostraLista();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		scan.close();
		
	}
}
