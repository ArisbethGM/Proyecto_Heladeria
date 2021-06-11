package Helad_CRUD.modelo;

public class Heladero {
    int id;
    String nom;
    String ed;
    String trn;
    
    public Heladero() {
        
    }

    public Heladero(int id, String nom, String ed, String trn) {
        this.id = id;
        this.nom = nom;
        this.ed = ed;
        this.trn = trn;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEd() {
        return ed;
    }

    public String getTrn() {
        return trn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }   
}