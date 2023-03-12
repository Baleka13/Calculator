package PaketK0;

public class FieldX0 {
    public char[][] field;
    int size = 9;
    int countToWin=5;

    void InField() {
        this.field = new char[size][size];
        for (int str = 0; str < size; str++) {
            for (int st = 0; st < size; st++) {
                field[str][st] = ' ';
            }
        }

        System.out.println("Field initialized");
        this.PrintField();
    }

    void PrintField() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int str = 0; str < size; str++) {
            int rowNumber = str + 1;
            System.out.print(rowNumber + " ");
            for (int st = 0; st < size; st++) {

                System.out.print("[" + this.field[str][st] + "]");
            }
            System.out.println();

        }
    }

    boolean isPlasefree(int rowIndex, int colinde) {
        if (rowIndex < 0 || rowIndex >= size || colinde < 0 || colinde >= size) {
            return false;
        }

        if (this.field[rowIndex][colinde] == ' ') {
            return true;
        } else {
            return false;

        }
    }

    void setValue( int rowindex, int colindex,char value){
        this.field[rowindex][colindex]=value;
    }

    boolean isGameover(char player){
        for(int row=0;row<this.size-this.countToWin;row++) {
            for (int col = 0; col < this.size; col++) {
                if (checkRightDirection(row,col,player)){
                    return true;}
                 else if (checkDownDirection(row,col,player)){
                    return true;
                 }else if (checkRightDirecion(row,col,player)){
                     return true;
                }else if(checkLeftDirection(row,col,player)){
                     return true;
                }
            }
        }
        return false;
    }
    boolean checkRightDirection(int row,int col, char player){
        if (col<this.size-this.countToWin) {
            checkRightDirection(row,col,player);
            return false;
        }
            for (int i=col;i<col+this.countToWin;i++){
                if(this.field[row][i]!=player){
                    return false;
                }
            }


        return true;
    }

    boolean checkDownDirection(int row,int col, char player){
        if (col<this.size-this.countToWin) {
            checkRightDirection(row,col,player);
            return false;
        }
        for (int i=col;i<row +this.countToWin;i++){
            if(this.field[i][col]!=player){
                return false;
            }
        }


        return true;
    }
    boolean checkRightDirecion(int row,int col, char player){
        if (col>this.size-this.countToWin) {
            checkRightDirection(row,col,player);
            return false;
        }
        if(col>this.size-this.countToWin){
            return false;
        }
        for (int sdvg=0;sdvg<this.countToWin;sdvg++){
            int rowTocheck=row+sdvg;
            int colTocheck=col+sdvg;
            if (this.field[rowTocheck][colTocheck]!=player) {
                return false;
            }
        }


        return true;
    }

    boolean checkLeftDirection(int row,int col, char player){
        if (col>this.size-this.countToWin) {
            checkRightDirection(row,col,player);
            return false;
        }
        if(col>=this.countToWin-1){
            return false;
        }
       for (int sdvg=0;sdvg<this.countToWin;sdvg++){
           int rowTocheck=row+sdvg;
           int colTocheck=col-sdvg;
           if (this.field[rowTocheck][colTocheck]!=player) {
               return false;
           }
       }


        return true;
    }
}

