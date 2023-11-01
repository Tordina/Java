package Kinoteatr;
public class Seans {
    public String time;
    public int price;
    public String duration;
    public Seans(String time, int price, String duration) {
        this.time = time;
        this.price = price;
        this.duration = duration;
    }

    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public String getDuration() {return duration;}
    public void setDuration(String duration) {this.duration = duration;}

}