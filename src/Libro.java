public class Libro extends Catalogo{

    int codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String autore;
    private Generi genere;
    private static int key = 0;

    Libro(int annoPubblicazione, String titolo, String autore, Generi genere, int numeroPagine){
        setNumeroPagine(numeroPagine);
        setGenere(genere);
        setTitolo(titolo);
        setAutore(autore);
        setAnnoPubblicazione(annoPubblicazione);
        codiceISBN = key++;
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

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Generi getGenere() {
        return genere;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
