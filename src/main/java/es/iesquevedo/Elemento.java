package es.iesquevedo;

public class Elemento {
    private String palabraSecreta;
    private String categoria;
    //constructor
    public Elemento(String palabra, String categoria) {
        this.palabraSecreta = palabra;
        this.categoria = categoria;
    }


    //Getter and Setters
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public void setPalabraSecreta(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    @Override
    public String toString() {
        return "Elemento{" +
                "palabra='" + palabraSecreta + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public String toStringFichero(){
        return palabraSecreta + ";"+categoria;
    }
}
