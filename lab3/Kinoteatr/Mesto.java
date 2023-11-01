package Kinoteatr;
public class Mesto {

    private int row;
    private int seat;
    private String status;

    public Mesto(int row, int seat) {
        this.row = row;
        this.seat = seat;
        this.status = "свободно";
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {this.row =row;}

    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {this.seat =seat;}

    public boolean isFree() {return this.status.equals("свободно");}

    public void occupy() {this.status = "занято";}


}

