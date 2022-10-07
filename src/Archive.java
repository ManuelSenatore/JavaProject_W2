import org.apache.commons.io.FileUtils;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Archive {

    public static void main(String[] args) {

        Archive archives = new Archive();
        Catalogo libro1 = new Libro(2000, "zio", "peppino", Generi.FANTASY, 566);
        Catalogo rivista1 = new Rivista("rissa", 2022, 40, Periodicita.MENSILE  );

        System.out.println(archives.getArchive());
        // archives.addElemBook(libro1);
        // archives.addElemBook(rivista1);
        

    }

    String[] arr;
    String archive = " ";

    List<Catalogo> catalogoList  = new ArrayList<>();

    public String getArchive(){
        setArchive();
        return archive;
    }
    public Catalogo getCatalogo(){
       return (Catalogo) (this.catalogoList = catalogoList);
    }

    public void setCatalogo(List<Catalogo> catalogoList){
        this.catalogoList = catalogoList;
    }
    private Generi determinaGenere(String str){
        switch (str) {
            case "COMMEDIA":
                return Generi.COMMEDIA;
            case "FANTASY":
                return Generi.FANTASY;
            case "GIALLO":
                return Generi.GIALLO;
            case "HORROR":
                return Generi.HORROR;
            default:
                return Generi.THRILLER;
        }
    }
    private Periodicita determinaPeriodicita(String str){
        switch (str) {
            case "MENSILE":
                return Periodicita.MENSILE;
            case "SEMESTRALE":
                return Periodicita.SEMESTRALE;
            default:
                return Periodicita.SETTIMANALE;
        }
    }
    public void setArchive(){
        String fileName = "docs/Biblioteca.txt";
        File myFile = new File(fileName);
        String encoding = "UTF-8";

        if (myFile.exists()){
            try {
                String fileContent = FileUtils.readFileToString(myFile, encoding);
                this.archive = fileContent;
                String[] arr = this.archive.split("/");

                for (int i = 0; i < arr.length; i++) {
                    String[] stringaSplit = arr[i].split(" ");
                    System.out.println(stringaSplit.length);
                    System.out.println(Arrays.toString(stringaSplit));
                for (int j = 0; j < stringaSplit.length; j++) {
                        if(stringaSplit.length == 6) {
                            Catalogo obj = new Libro(Integer.parseInt(stringaSplit[0]), stringaSplit[1],
                                    stringaSplit[2], determinaGenere(stringaSplit[3]), Integer.parseInt(stringaSplit[4]));
                            catalogoList.add(obj);
                        } else {
                            Catalogo obj = new Rivista(stringaSplit[0],
                                    Integer.parseInt(stringaSplit[1]), Integer.parseInt(stringaSplit[2]), determinaPeriodicita(stringaSplit[3]));
                            catalogoList.add(obj);
                            }
                    }
                }
            } catch( IOException e ) {
                System.out.println( "Error" );
            }
        } else
            try{
                FileUtils.writeStringToFile(myFile, " ", encoding);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public void addElemBook(Catalogo obj){
        if(obj instanceof Libro){
            String fileName = "docs/Biblioteca.txt";
            File myFile = new File(fileName);
            String encoding = "UTF-8";

            try {
                FileUtils.writeStringToFile( myFile, "" +
                          ((Libro) obj).getAnnoPubblicazione() + " "
                        + ((Libro) obj).getTitolo() + " "
                        + ((Libro) obj).getAutore() + " "
                        + ((Libro) obj).getGenere() + " "
                        + ((Libro) obj).getNumeroPagine() +
                         " " + "LIBRO" + "/",  encoding, true );
            } catch( IOException e ) {
                throw new RuntimeException( e );
            }
        } else if(obj instanceof Rivista) {
            String fileName = "docs/Biblioteca.txt";
            File myFile = new File(fileName);
            String encoding = "UTF-8";

            try {
                FileUtils.writeStringToFile( myFile, ""

                        + ((Rivista) obj).getTitolo() + " "
                        + ((Rivista) obj).getAnnoPubblicazione() + " "
                        + ((Rivista) obj).getNumeroPagine() + " "
                        + ((Rivista) obj).getPeriodicita() +
                        " " + "RIVISTA" + "/",  encoding, true );
            } catch( IOException e ) {
                throw new RuntimeException( e );
            }

        }
        setArchive() ;
    }
    public void delElem(int Isbn){
        try{
            List<Catalogo> delList = catalogoList.stream().filter(e -> e.codiceISBN != Isbn).collect(Collectors.toList());
            ArrayList<Catalogo> finalResult = ((ArrayList) delList);
            setCatalogo(finalResult);
        } catch (Exception e){
            System.out.println("Errore");
        }
    }
    public void searchIsbn(int isbn) {
        try {
            List<Catalogo> searchedList = catalogoList.stream()
                    .filter(c -> c.codiceISBN == isbn).toList();

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void searchAuthor(String author) {
        try {
            List<Catalogo> searchedList = catalogoList.stream()
                    .filter(c -> c instanceof Libro)
                    .map(c -> (Libro) c)
                    .filter((c -> c.getAutore() == author))
                    .collect(Collectors.toList());

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void searchYear(int year) {
        try {
            List<Catalogo> searchedList = catalogoList.stream()
                    .filter((c -> c.annoPubblicazione == year))
                    .collect(Collectors.toList());

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

}
