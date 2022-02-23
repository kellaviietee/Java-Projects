package ee.taltech.iti0202.tk1.art;

public class Painting {

    private  String title;
    private String author;

    public Painting(String title, String author){

        this.title = title;
        this.author = author;
    }

    public Painting(String title){

        this.title = title;
        this.author = "";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String author){
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        if (!author.equals("")) {
            return "This is a painting named " + title + " and made by " + author + ".";
        } else {
            return "This is a painting named " + title + " and made by an unknown artist.";
        }
    }
}
