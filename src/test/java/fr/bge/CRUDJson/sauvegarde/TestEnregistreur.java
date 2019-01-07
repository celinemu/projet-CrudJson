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

	//on charge la liste actuelle de vêtements
		List < Vetement > dressing1 = enregistreur.lireTous();
		
	//on instancie un nouveau vêtement
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille("37");
		chaussure.setCouleur("Rouge");
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
				
		
	// on sauvegarde ce nouveau vêtement
		enregistreur.enregistrer(chaussure);
		
	// on vérifie que la liste à pris en compte ce vêtement
		List <Vetement> dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouveau dressing a un élément de plus", dressing1.size() + 1, dressing2.size());//class Assert avec méthode statique donc il faut rajouter la dépendance vers junit  cf manip dans pom
		
	//on modifie ce vêtement
		chaussure.setTaille("40");
		enregistreur.enregistrer(chaussure);		
		
	//on vérifie que la liste à pris en compte cette modification
		
	//on supprime le vêtement
		enregistreur.supprimer(chaussure);
		
	//on vérifie que la liste  pris en compte cette suppression
		List <Vetement> dressing3 = enregistreur.lireTous();
		Assert.assertEquals("Les 2 dressings doivent avoir le même nombre d'éléments", dressing1.size() , dressing3.size());//class Assert avec méthode statique donc il faut rajouter la dépendance vers junit  cf pom
			
		
	}
}
