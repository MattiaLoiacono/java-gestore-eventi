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
			
			Evento x = new Evento(titolo, data, postiTot);
			System.out.print(x.toString());
			
			
			
			scan.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
