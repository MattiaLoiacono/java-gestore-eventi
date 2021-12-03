package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(System.in);
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
			
			// ho creato più oggetti scanner perchè entrando in un Exception il programma non passa per scan.close()
			
			System.out.print("Quanti biglietti vuoi prenotare? ");
			int prenotazioni = scan.nextInt();
			if(prenotazioni >= 0 && prenotazioni <= postiDisponibili) {
				for(int i=0; i < prenotazioni; i++) {
					x.prenota();
				}
				postiDisponibili -= prenotazioni;  
			}else if(prenotazioni >= 0 && prenotazioni > postiDisponibili){
				scan.close();
				throw new Exception("Impossibile prenotare un numero di biglietti maggiore della disponibilità");
			}else {
				scan.close();
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
				scan.close();
				throw new Exception("Impossibile disdire un numero di biglietti maggiore delle prenotazioni effettuate");
			}else {
				scan.close();
				throw new Exception("Impossibile disdire un numero negativo di biglietti");
			}
			
			System.out.println("Posti prenotati: " + x.getPostiPrenotati());
			System.out.println("Posti disponibili: " + postiDisponibili);
			
			scan.close();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
}
