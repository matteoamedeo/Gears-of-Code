package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.DefaultListCellRenderer.UIResource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.json.JSONObject;

import dao.DAOEsercizi;
import dao.DAOPersone;
import dao.DAOSoluzioni;
import entities.Esercizio;
import entities.Persona;
import entities.Soluzione;
import interfaces.IDAOEsercizi;
import interfaces.IDAOPersone;
import interfaces.IDAOSoluzioni;
import rest.Api;
import utilities.Utility;
import viste.GestoreTemplate;

public class Main {

	public static void main(String[] args) {

		IDAOPersone ip = new DAOPersone("gearsofcode");
		IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
		IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");

		//		String linguaggioScelto = "java";
		//		String livelloScelto = "livello1";
		//		String percorso = "src/main/java/res/" + linguaggioScelto + "/soluzioni/" + livelloScelto + "/";
		//		String percorsoSoluzioni = "src/main/java/res/" + linguaggioScelto + "/soluzioni/" + livelloScelto + "/PossibilitiesArrays/";
		//		System.out.println(ip.stampaLista(ip.read()));
		//		System.out.println(il.stampaLista(il.read()));
		//		System.out.println(ie.stampaLista(ie.read()));
		//		System.out.println(is.stampaLista(is.read()));
		//		System.out.println(Utility.fileString(percorso + ie.read().get(0).get("corpo")));
		//		System.out.println(Utility.fileString(percorsoSoluzioni + is.read().get(0).get("opzione1")));

		//		Persona p = new Persona ();
		//		p.setUsername("prova");
		//		p.setPassword("passprova");
		//		p.setEmail("prova@outlook.it");
		//		ip.create(p);
		//		
		//		Esercizio e = new Esercizio();
		//		e.setLinguaggio("Java");
		//		e.setTitolo("Prova Esercizio");
		//		e.setLivello(3);
		//		e.setPunti(2);
		//		e.setCorpo("ProvaEsercizio.txt");
		//		ie.create(e);
		//		
		//		String corpo = "nuovo esercizio di livello 3";
		//		
		//		Soluzione s = new Soluzione();
		//		s.setOpzione1(e.getTitolo().trim() + "_opzione1.txt");
		//		s.setOpzione2(e.getTitolo().trim() + "_opzione2.txt");
		//		s.setOpzione3(e.getTitolo().trim() + "_opzione3.txt");
		//		is.create(s);
		//		
		//		String opzione1 = "opzione1";
		//		String opzione2 = "opzione2";
		//		String opzione3 = "opzione3";
		//		
		//		Utility.writeEsercizio(e.getLinguaggio(),e.getLivello(),e.getCorpo(), corpo);
		//		Utility.writeSoluzione(e.getLinguaggio(),e.getLivello(),e.getCorpo(),e.getId(),opzione1,opzione2,opzione3);

		//		System.out.println(ip.login("simone.mattei", "jaita50"));
		//		GestoreTemplate GT = new GestoreTemplate("C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src\\main\\webapp\\viste\\HTML\\");
		//		System.out.println(GT.eserciziJSON(ie.elencoEsercizi()));
		//		System.out.println(GT.eserciziToJSON());


		
		
	}
	 


}
