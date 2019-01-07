package fr.bge.CRUDJson.sauvegarde;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.bge.CRUDJson.entites.Chaussure;
import fr.bge.CRUDJson.entites.Fabricant;
import fr.bge.CRUDJson.entites.Vetement;

public class TestEnregistreur {
	
	@Test
	public void testFonctionnementClassique()  throws Exception {
		
		Enregistreur enregistreur = new Enregistreur();

	//on charge la liste actuelle de v�tements
		List < Vetement > dressing1 = enregistreur.lireTous();
		
	//on instancie un nouveau v�tement
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille("37");
		chaussure.setCouleur("Rouge");
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
				
		
	// on sauvegarde ce nouveau v�tement
		enregistreur.enregistrer(chaussure);
		
	// on v�rifie que la liste � pris en compte ce v�tement
		List <Vetement> dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouveau dressing a un �l�ment de plus", dressing1.size() + 1, dressing2.size());//class Assert avec m�thode statique donc il faut rajouter la d�pendance vers junit  cf manip dans pom
		
	//on modifie ce v�tement
		chaussure.setTaille("40");
		enregistreur.enregistrer(chaussure);		
		
	//on v�rifie que la liste � pris en compte cette modification
		
	//on supprime le v�tement
		enregistreur.supprimer(chaussure);
		
	//on v�rifie que la liste  pris en compte cette suppression
		List <Vetement> dressing3 = enregistreur.lireTous();
		Assert.assertEquals("Les 2 dressings doivent avoir le m�me nombre d'�l�ments", dressing1.size() , dressing3.size());//class Assert avec m�thode statique donc il faut rajouter la d�pendance vers junit  cf pom
			
		
	}
}
