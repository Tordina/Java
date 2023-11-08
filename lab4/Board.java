import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
    //TODO: Список фигур и начальное положение всех фигур
    private Figure  fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);
    //возвращаем где находиться король
    private int getKingRow(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] instanceof King && fields[row][col].getColor() == color) {
                    return row;
                }
            }
        }

        return -1;
    }
    private int getKingCol(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] instanceof King && fields[row][col].getColor() == color) {
                    return col;
                }
            }
        }

        return -1;
    }

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }
//перемещаем фигуру
    public boolean move_figure(int row1, int col1, int row2, int col2) {
        Figure figure = fields[row1][col1];
        if (figure != null && figure.canMove(row1, col1, row2, col2)) {
            if (fields[row2][col2] == null || fields[row2][col2].getColor() != figure.getColor()) {
                fields[row2][col2] = figure;
                fields[row1][col1] = null;
                return true;
            }
        } else if (figure.canAttack(row1, col1, row2, col2) && fields[row2][col2] != null && fields[row2][col2].getColor() != figure.getColor()) {
            //проверка наличия препятсвия для атаки
            if (!Let(row1, col1, row2, col2)) {
                // Проверяем, не является ли атакуемая фигура королём
                if (!(fields[row2][col2] instanceof King)) {
                    switch (fields[row2][col2].getColor()) {
                        case 'w':
                            takeWhite.add(fields[row2][col2].getColor() + fields[row2][col2].getName());
                            break;
                        case 'b':
                            takeBlack.add(fields[row2][col2].getColor() + fields[row2][col2].getName());
                            break;
                    }
                    fields[row2][col2] = figure;
                    fields[row1][col1] = null;
                    return true;
                }
            }
        }
        return false;
    }
//проверяем есть ли препятствия
    private boolean Let(int row1, int col1, int row2, int col2) {
        int rowDir = Integer.compare(row2 - row1, 0);
        int colDir = Integer.compare(col2 - col1, 0);
        int currentRow = row1 + rowDir;
        int currentCol = col1 + colDir;

        while (currentRow != row2 || currentCol != col2) {
            if (fields[currentRow][currentCol]!= null && fields[currentRow][currentCol] instanceof Knight) {//конь может перепрыгивать через фигуры
                return true;
            }
            currentRow += rowDir;
            currentCol += colDir;
        }
        return false;
    }
    // Проверяем находится ли король под шахом
    public boolean Check(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] != null && fields[row][col].getColor() != color) {
                    if (fields[row][col].canAttack(row, col, getKingRow(color), getKingCol(color))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Проверяем, есть ли мат
    public boolean Mate() {
        if (Check('b')) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (fields[row][col] != null && fields[row][col].getColor() == 'b' && fields[row][col].canMove(row, col, getKingRow('b'), getKingCol('b'))) {
                        if (!CheckAfterMove(row, col, getKingRow('b'), getKingCol('b'), 'b')) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (Check('w')) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (fields[row][col] != null && fields[row][col].getColor() == 'w' && fields[row][col].canMove(row, col, getKingRow('w'), getKingCol('w'))) {
                        if (!CheckAfterMove(row, col, getKingRow('w'), getKingCol('w'), 'w')) {
                            return true;
                        }
                    }
                }

            }
            return false;
        }
        return false;
    }

    // проверяем оказывается ли король под шахом после хода
    public boolean CheckAfterMove(int fromRow, int fromCol, int toRow, int toCol, char color) {
        Figure temp = fields[toRow][toCol];
        fields[toRow][toCol] = fields[fromRow][fromCol];
        fields[fromRow][fromCol] = null;

        boolean result = Check(color);

        fields[fromRow][fromCol] = fields[toRow][toCol];
        fields[toRow][toCol] = temp;

        return result;
    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }


        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }


    }


}