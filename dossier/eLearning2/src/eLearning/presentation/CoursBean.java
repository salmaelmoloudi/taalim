package eLearning.presentation;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import eLearning.dao.Classe;
import eLearning.dao.Cours;
import eLearning.services.ClasseService;
import eLearning.services.ClasseServiceImpl;
import eLearning.services.CoursService;
import eLearning.services.CoursServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

@ManagedBean(name="CoursBean1")
@ApplicationScoped
public class CoursBean {
	
	private CoursService coursservice = new CoursServiceImpl();
	private ClasseService classeservice = new ClasseServiceImpl();

	
	
	private String nomcours;
	private String contenu;
	private String cat�gorie;
	private String succ�s;
	private static Cours leCours;
	public Cours getLeCours() {
		return leCours;
	}





	public void setLeCours(Cours leCours) {
		this.leCours = leCours;
	}

	private List<String> cat�gories;
	public List<String> getCat�gories() {
		return cat�gories;
		
	}
	
	private List<Cours> listcours;
	
	
	@PostConstruct
	public void initBean() {
        /*cat�gories = new ArrayList<String>();

		List<Classe> listclasse = classeservice.findAll();	
		for(Classe o : listclasse) {
			cat�gories.add(o.getNom_classe());
		}*/
		
		listcours = coursservice.findAll();
		
		
		
		
	}
	
	
	
	
	
	public CoursBean() {
        cat�gories = new ArrayList<String>();
		
		cat�gories.add("Informatique");
		cat�gories.add("M�decine");
		cat�gories.add("Litt�rature"); 
	}




	public void setCat�gories(List<String> cat�gories) {
		this.cat�gories = cat�gories;
	}
	
	public String getCat�gorie() {
		return cat�gorie;
	}

	public void setCat�gorie(String cat�gorie) {
		this.cat�gorie = cat�gorie;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	

	public String getNomcours() {
		return nomcours;
	}

	public void setNomcours(String nomcours) {
		this.nomcours = nomcours;
	}
	
	
	
	
	public String getSucc�s() {
		return succ�s;
	}



	public void setSucc�s(String succ�s) {
		this.succ�s = succ�s;
	}



	public List<Cours> getListcours() {
		return listcours;
	}



	public void setListcours(List<Cours> listcours) {
		this.listcours = listcours;
	}



	public void addCours(ActionEvent e) {
		
		succ�s="";
		System.out.println(nomcours);
		System.out.println(contenu);
		System.out.println(cat�gorie);
		
		Cours c = new Cours();
		c.setNom_cours(nomcours);
		c.setContenu(contenu);
		c.setCat�gorie(cat�gorie);
		coursservice.add(c);
		
		nomcours="";
		contenu="";
		cat�gorie="";
		
		succ�s = "le cours est bien ajout�";
		

		
	}
	
	public String fonction() {
		
		System.out.println("here");
		int id;		
		id = Integer.parseInt(FacesContext.getCurrentInstance()
						.getExternalContext().getRequestParameterMap()
						.get("id_cours"));
		leCours = coursservice.findById((long) id);
		return ("ContenuCours.xhtml");
		
	}
	
	
	
	
	

}
