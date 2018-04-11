package it.polito.tdp.regine;

import java.util.ArrayList;
import java.util.List;

/**
 * La disposizione di un certo numero di regine sulla scacchiera
 * 
 * @author Fulvio
 *
 */
public class Regine {
	
	public List<Integer> posiziona(int N) {
		List <Integer> soluzione=new ArrayList<Integer>();
		if (cerca(soluzione,N,0)) {
			return soluzione;
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * Assumendo che scacchiera sia piena nelle righe da 0 a livello-1,
	 * determina le possibili posizioni per una regina alla riga==livello
	 * e prova ricorsivamente a posizionarla.
	 * @param scacchiera lista delle posizioni (colonna) delle regine precedenti
	 * @param N dimensione scacchiera
	 * @param livello riga a cui deve lavorare la ricorsione
	 */
	
	private boolean cerca(List<Integer> scacchiera,int N, int livello) {
		//scacchiera corrisponde alla variabile parziale nell'esercizio precedente
		if (livello==N) {
			//caso terminale, soluzione trovata
			System.out.println(scacchiera);
			return true;
		}
		
		for (int mossa=0;mossa<N;mossa++) {
			//tutte le colonne della scacchiera(matrice)
			if(posizioneSicura(scacchiera,livello,N,mossa))
			scacchiera.add(mossa);
			if(cerca(scacchiera,N,livello+1))
				return true;
			scacchiera.remove(livello);
		}
		return false;
	}

	private boolean posizioneSicura(List<Integer> scacchiera, int livello, int n, int mossa) {
		for (int riga=0;riga<livello;riga++) {
			
			//C'è almeno una delle regine delle righe superiori sulla stessa colonna della mossa che sto per fare?
			//Se sì allora mi ritornerà falso
			//Controllo a ogni riga dov'è stata posizionata la regina in quella riga e mi salvo la colonna, che vado a confrontare
			
			if (scacchiera.get(riga)==mossa) {
				return false;
			}
			

			//CONTROLLO DIAGONALE DESTRA
			
			if (riga-scacchiera.get(riga)==livello-mossa)
				return false;
			
			
			//CONTROLLO DIAGONALE SINISTRA	
			
			if (riga+scacchiera.get(riga)==livello+mossa)
				return false;
			
		}
		
		
		return true;
	}

}




/*
*  [Q]  -->R1=riga, C1=scacchiera.get(riga)
*  
*  
*  					[Q]--->R2=livello, C2=mossa
*  
*  
*  Condizione per cui possa mangiare in diagonale è che righe e colonne siano uguali
*  Diagonale destra: R1-C1=R2-C2
*  Diagonale sinistra: R1+C1=R2+C2
*  
*  
*  
*/