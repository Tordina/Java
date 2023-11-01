package Kinoteatr;
import java.util.ArrayList;
public class Hall {
    private int hallNumber;
    private int rows;
    private int seats;
    private ArrayList<ArrayList<Mesto>> cinema;

    public Hall(int hallNumber, int rows, int seats) {
        this.hallNumber = hallNumber;
        this.rows = rows;
        this.seats = seats;
        this.cinema = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Mesto> row = new ArrayList<>();
            for (int j = 0; j < seats; j++) {
                Mesto mesto = new Mesto(i + 1, j + 1);
                row.add(mesto);
            }
            cinema.add(row);
        }
    }
    public int getHallNumber() {
        return hallNumber;
    }
    public void setHallNumber(int hallNumber) {this.hallNumber =hallNumber;}

    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows =rows;
    }

    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats =seats;
    }

    public void printHallPlan() {
        System.out.println("         --- Зал " + hallNumber + " ---");
        System.out.print("  ");
        for (int i = 0; i < cinema.get(0).size(); i++) {
            System.out.print("  "+( i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < cinema.size(); i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema.get(i).size(); j++) {
                System.out.print(cinema.get(i).get(j).isFree() ? " |-|" : "  З ");
            }
            System.out.println();
        }
    }

    public Mesto getMesto(int row, int seat) {
        if (row <= 0 || row > rows || seat <= 0 || seat > seats) {
            System.out.println("Ошибка: выбранное место недопустимо!");
            return null;
        }
        return cinema.get(row - 1).get(seat - 1);
    }
}
