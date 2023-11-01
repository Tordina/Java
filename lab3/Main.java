import java.util.ArrayList;
import java.util.List;
import Kinoteatr.Hall;
import Kinoteatr.Seans;
import Kinoteatr.Kinoteatr;
import Kinoteatr.Mesto;
import Kinoteatr.Film;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kinoteatr kinoteatr1 = new Kinoteatr("Рублион");
        Kinoteatr kinoteatr2 = new Kinoteatr("Кронверк");

        Film film1 = new Film("Леди баг");
        Film film2 = new Film("Бражник");

        kinoteatr1.addFilm(film1);
        kinoteatr1.addFilm(film2);
        kinoteatr2.addFilm(film1);
        kinoteatr2.addFilm(film2);
        Seans seans1 = new Seans("10:00", 500, "1.50");
        Seans seans2 = new Seans("12:00", 350, "2.10");
        Seans seans3 = new Seans("13:00", 450, "1.50");
        Seans seans4 = new Seans("16:00", 250, "2.10");

        kinoteatr1.addSeans("Леди баг", seans1);
        kinoteatr1.addSeans("Бражник", seans2);
        kinoteatr2.addSeans("Леди баг", seans3);
        kinoteatr2.addSeans("Бражник", seans4);


        Hall hall1 = new Hall(1, 10, 10);
        Hall hall2 = new Hall(2, 10, 10);

        System.out.println("Кинотеатры :");
        System.out.println(kinoteatr1.getName());
        System.out.println(kinoteatr2.getName());
        System.out.println("Введите нужный  кинотеатр:");
        String inputLine = in.nextLine();

        if (inputLine.equals("Рублион")) {
            System.out.println("Афиша :");
            List<Film> films1 = kinoteatr1.getFilms();
            for (Film film : films1) {
                System.out.println(film.getName());
            }
            List<Seans> seanses1 = kinoteatr1.getSeanses("Леди баг");
            List<Seans> seanses2 = kinoteatr1.getSeanses("Бражник");
            System.out.println("Введите нужное кино :");
            String input = in.nextLine();
            if (input.equals("Леди баг")) {
                for (Seans seans : seanses1) {
                    System.out.println("Время: " + seans.getTime() + ", Цена: " + seans.getPrice() + ", Продолжительность: "
                            + seans.getDuration());
                    mesta(hall1);
                }

            } else if (input.equals("Бражник")) {
                for (Seans seans : seanses2) {
                    System.out.println("Время: " + seans.getTime() + ", Цена: " + seans.getPrice() + ", Продолжительность: " +
                            seans.getDuration());
                    mesta(hall2);
                }
            }

        } else if (inputLine.equals("Кронверк")) {
            System.out.println("Афиша :");
            List<Film> films2 = kinoteatr2.getFilms();
            for (Film film : films2) {
                System.out.println(film.getName());
            }
            List<Seans> seanses1 = kinoteatr2.getSeanses("Леди баг");
            List<Seans> seanses2 = kinoteatr2.getSeanses("Бражник");
            System.out.println("Введите нужное кино :");
            String input = in.nextLine();
            if (input.equals("Леди баг")) {
                for (Seans seans : seanses1) {
                    System.out.println("Время: " + seans.getTime() + ", Цена: " + seans.getPrice() + ", Продолжительность: "
                            + seans.getDuration());
                    mesta(hall2);
                }
            } else if (input.equals("Бражник")) {
                for (Seans seans : seanses2) {
                    System.out.println("Время: " + seans.getTime() + ", Цена: " + seans.getPrice() + ", Продолжительность: " +
                            seans.getDuration());
                    mesta(hall2);
                }
            }

        }
    }

    public static void mesta(Hall hall) {
        Scanner in = new Scanner(System.in);
        ArrayList<Mesto> selectedMesta = new ArrayList<>();
        hall.printHallPlan();
        while (true) {
            System.out.print("Выберите ряд : ");
            int row= in.nextInt();
            System.out.print("Выберите место: ");
            int seat = in.nextInt();

            Mesto selectedMesto = hall.getMesto(row, seat);
            if (selectedMesto != null) {
                if (selectedMesto.isFree()) {
                    selectedMesto.occupy();
                    selectedMesta.add(selectedMesto);
                    System.out.println("Место забронировано успешно");
                } else {
                    System.out.println("Место занято, выберите другое");
                }
            } else {
                System.out.println("Место не найдено, выберите другое");
            }
            System.out.println("Хотите продолжить покупку билетов ?(Да/Нет)");
            String input = in.next();
            if (input.equals("Нет")) {
                hall.printHallPlan();
                return ;
            }

        }
    }
}