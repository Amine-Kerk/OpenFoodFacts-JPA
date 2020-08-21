package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Produit")
public class Produit {
	// id produit auto-incrementé
	// Générer getter/setter et to string
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NOM", length = 300, nullable = false, unique = true)
	private String nomprod;
	@ManyToOne
	@JoinColumn(name = "id_cat", nullable = false, unique = true)
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "id_mrq", nullable = false, unique = true)
	private Marque marque;
	@ManyToMany
	@JoinTable(name = "jointure_produit_ingredients", joinColumns = @JoinColumn(name = "id_prd"), inverseJoinColumns = @JoinColumn(name = "id_ing"))
	private List<Ingredient> listingredients = new ArrayList<Ingredient> ();
	@ManyToMany
	@JoinTable (name = "jointure_produit_all", joinColumns = @JoinColumn (name = "id_prd"),inverseJoinColumns = @JoinColumn (name = "id_all"))
	private List<Allergene> listallergene = new ArrayList<Allergene>();
	
	@ManyToMany
	@JoinTable (name = "jointure_produit_add", joinColumns = @JoinColumn (name ="id_prd" ),inverseJoinColumns = @JoinColumn (name = "id_add"))
	private List<Additif> listadditif = new ArrayList<Additif> (); 
			
	@Column(name = "GRADENUTRI", length = 100, nullable = true, unique = true)
	private String gradenutri;
	@Column(name = "ENERGIE100g", length = 100, nullable = true, unique = true)
	private double energie;
	@Column(name = "GRAISSE100g", length = 100, nullable = true, unique = true)
	private double graisse;
	@Column(name = "SUCRE100g", length = 100, nullable = true, unique = true)
	private double sucre;
	@Column(name = "FIBRES100g", length = 100, nullable = true, unique = true)
	private double fibres;
	@Column(name = "PROTEINES100g", length = 100, nullable = true, unique = true)
	private double proteines;
	@Column(name = "SEL100g", length = 100, nullable = true, unique = true)
	private double sel;
	@Column(name = "VITA100g", length = 100, nullable = true, unique = true)
	private double vitA;
	@Column(name = "VITD100g", length = 100, nullable = true, unique = true)
	private double vitD;
	@Column(name = "VITE100g", length = 100, nullable = true, unique = true)
	private double vitE;
	@Column(name = "VITK100g", length = 100, nullable = true, unique = true)
	private double vitK;
	@Column(name = "VITC100g", length = 100, nullable = true, unique = true)
	private double vitC;
	@Column(name = "VITB1100g", length = 100, nullable = true, unique = true)
	private double vitB1;
	@Column(name = "VITB200g", length = 100, nullable = true, unique = true)
	private double vitB2;
	@Column(name = "VITPP100g", length = 100, nullable = true, unique = true)
	private double vitPP;
	@Column(name = "VITB6100g", length = 100, nullable = true, unique = true)
	private double vitB6;
	@Column(name = "VITB9100g", length = 100, nullable = true, unique = true)
	private double vitB9;
	@Column(name = "VITB12100g", length = 100, nullable = true, unique = true)
	private double vitB12;
	@Column(name = "CALCIUM100g", length = 100, nullable = true, unique = true)
	private double calcium;
	@Column(name = "MAGNESIUM100g", length = 100, nullable = true, unique = true)
	private double magnesium;
	@Column(name = "IRON100g", length = 100, nullable = true, unique = true)
	private double iron;
	@Column(name = "FER100g", length = 100, nullable = true, unique = true)
	private double fer;
	@Column(name = "BETACAROTENE100g", length = 100, nullable = true, unique = true)
	private double betacarotene;
	@Column(name = "PRESENCEHUILEDEPALME", length = 100, nullable = true, unique = true)
	private String presencehuiledepalme;
	// Constructeur sans parametre de l'entity produit
	public Produit() {

	}

	public Produit(String nomprod) {
		super();
		this.nomprod = nomprod;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomprod() {
		return nomprod;
	}
	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public List<Ingredient> getListingredients() {
		return listingredients;
	}
	public void setListingredients(List<Ingredient> listingredients) {
		this.listingredients = listingredients;
	}
	public String getGradenutri() {
		return gradenutri;
	}
	public void setGradenutri(String gradenutri) {
		this.gradenutri = gradenutri;
	}
	public double getEnergie() {
		return energie;
	}
	public void setEnergie(double energie) {
		this.energie = energie;
	}
	public double getGraisse() {
		return graisse;
	}
	public void setGraisse(double graisse) {
		this.graisse = graisse;
	}
	public double getSucre() {
		return sucre;
	}
	public void setSucre(double sucre) {
		this.sucre = sucre;
	}
	public double getFibres() {
		return fibres;
	}
	public void setFibres(double fibres) {
		this.fibres = fibres;
	}
	public double getProteines() {
		return proteines;
	}
	public void setProteines(double proteines) {
		this.proteines = proteines;
	}
	public double getSel() {
		return sel;
	}
	public void setSel(double sel) {
		this.sel = sel;
	}
	public double getVitA() {
		return vitA;
	}
	public void setVitA(double vitA) {
		this.vitA = vitA;
	}
	public double getVitD() {
		return vitD;
	}
	public void setVitD(double vitD) {
		this.vitD = vitD;
	}
	public double getVitE() {
		return vitE;
	}
	public void setVitE(double vitE) {
		this.vitE = vitE;
	}
	public double getVitK() {
		return vitK;
	}
	public void setVitK(double vitK) {
		this.vitK = vitK;
	}
	public double getVitC() {
		return vitC;
	}
	public void setVitC(double vitC) {
		this.vitC = vitC;
	}
	public double getVitB1() {
		return vitB1;
	}
	public void setVitB1(double vitB1) {
		this.vitB1 = vitB1;
	}
	public double getVitB2() {
		return vitB2;
	}
	public void setVitB2(double vitB2) {
		this.vitB2 = vitB2;
	}
	public double getVitPP() {
		return vitPP;
	}
	public void setVitPP(double vitPP) {
		this.vitPP = vitPP;
	}
	public double getVitB6() {
		return vitB6;
	}
	public void setVitB6(double vitB6) {
		this.vitB6 = vitB6;
	}
	public double getVitB9() {
		return vitB9;
	}
	public void setVitB9(double vitB9) {
		this.vitB9 = vitB9;
	}
	public double getVitB12() {
		return vitB12;
	}
	public void setVitB12(double vitB12) {
		this.vitB12 = vitB12;
	}
	public double getCalcium() {
		return calcium;
	}
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	public double getMagnesium() {
		return magnesium;
	}
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	public double getIron() {
		return iron;
	}
	public void setIron(double iron) {
		this.iron = iron;
	}
	public double getFer() {
		return fer;
	}
	public void setFer(double fer) {
		this.fer = fer;
	}
	public double getBetacarotene() {
		return betacarotene;
	}
	public void setBetacarotene(double betacarotene) {
		this.betacarotene = betacarotene;
	}
	public String getPresencehuiledepalme() {
		return presencehuiledepalme;
	}
	public void setPresencehuiledepalme(String presencehuiledepalme) {
		this.presencehuiledepalme = presencehuiledepalme;
	}
	public List<Allergene> getListallergene() {
		return listallergene;
	}
	public void setListallergene(List<Allergene> listallergene) {
		this.listallergene = listallergene;
	}
	public List<Additif> getListadditif() {
		return listadditif;
	}
	public void setListadditif(List<Additif> listadditif) {
		this.listadditif = listadditif;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomprod=" + nomprod + ", gradenutri=" + gradenutri + ", energie=" + energie
				+ ", graisse=" + graisse + ", sucre=" + sucre + ", fibres=" + fibres + ", proteines=" + proteines
				+ ", sel=" + sel + ", vitA=" + vitA + ", vitD=" + vitD + ", vitE=" + vitE + ", vitK=" + vitK + ", vitC="
				+ vitC + ", vitB1=" + vitB1 + ", vitB2=" + vitB2 + ", vitPP=" + vitPP + ", vitB6=" + vitB6 + ", vitB9="
				+ vitB9 + ", vitB12=" + vitB12 + ", calcium=" + calcium + ", magnesium=" + magnesium + ", iron=" + iron
				+ ", fer=" + fer + ", betacarotene=" + betacarotene + ", presencehuiledepalme=" + presencehuiledepalme
				+ "]";
	}
}

