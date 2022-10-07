public class Rivista extends Catalogo{

    int codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    Periodicita periodicita;
    private static int key = 0;

    Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita){

        setAnnoPubblicazione(annoPubblicazione);
        setTitolo(titolo);
        setAnnoPubblicazione(annoPubblicazione);
        setNumeroPagine(numeroPagine);
        setPeriodicita(periodicita);
        codiceISBN = key++;
    }

    public Periodicita getPeriodicita(){
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

}
