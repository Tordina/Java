package Kinoteatr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Kinoteatr {
    public String name;
    public List<Film> films;

    private Map<String, List<Seans>> seanses;

    public Kinoteatr(String name) {
        this.name = name;
        this.films = new ArrayList<>();
        this.seanses = new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {return films;}

    public void setFilms(List<Film> films) {
        this.films = films;
    }
    public void addFilm(Film film) {
        this.films.add(film);
    }

    public void addSeans(String filmName, Seans seans) {
        List<Seans> filmSeanses = seanses.getOrDefault(filmName, new ArrayList<>());
        filmSeanses.add(seans);
        seanses.put(filmName, filmSeanses);
    }

    public List<Seans> getSeanses(String filmName) {
        return seanses.getOrDefault(filmName, new ArrayList<>());
    }
}

