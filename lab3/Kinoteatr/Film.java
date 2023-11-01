package Kinoteatr;
import java.util.ArrayList;
import java.util.List;

public class Film {
    public String name;
    public List<Seans> seanses;

    public Film(String name) {
        this.name = name;
        this.seanses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Seans> getSeanses() {return seanses;}
    public void setSeanses(List<Seans> seanses) {this.seanses = seanses;}

    public void addSeans(Seans seans) {this.seanses.add(seans);}
}