package Clien_CRUD.modelo;

public class Cliente {
    int idc;
    String nbr;
    String ead;
    String sf;

    public Cliente() {
    }

    public Cliente(int idc, String nbr, String ead, String sf) {
        this.idc = idc;
        this.nbr = nbr;
        this.ead = ead;
        this.sf = sf;
    }

    public int getIdc() {
        return idc;
    }

    public String getNbr() {
        return nbr;
    }

    public String getEad() {
        return ead;
    }

    public String getSf() {
        return sf;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public void setEad(String ead) {
        this.ead = ead;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }
}