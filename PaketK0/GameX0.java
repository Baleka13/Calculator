package PaketK0;

import java.util.Scanner;

public class GameX0 {
    FieldX0 GameField;
    Scanner scanner= new Scanner(System.in);
    char who;
    boolean gameover=false;
    void setupNewGame(){
        System.out.println("Will play new X0 game");
        this.GameField= new FieldX0();
        this.GameField.InField();
    }
    void play() {
        this.setupNewGame();
        System.out.println("Who will make first turn: ");
        char first = 0;
        try {
            String next = this.scanner.next();
            first = this.scanner.next().charAt(0);
        } catch (Exception e) {
            System.out.println("Вы ввели неправильное значение");
        }
        if (first == 'X' || first == '0') {
            this.who = first;
        } else {
            System.out.println("I recognizind only X and 0(zero). So first will be X");
            this.who = 'X';

        }
        while (!gameover) {
            turn();
            this.gameover = this.GameField.isGameover(this.who);
            if (this.gameover) {
                System.out.println(this.who + "win!");
            }
            if (this.who == 'X') {
                this.who = '0';
            } else {
                this.who = 'X';
            }
        }
        System.out.println("Game over");
    }
void turn(){
    System.out.println(this.who+" ,you turn.");
    System.out.println("Chose row");
    int row=this.scanner.nextInt();
    System.out.println("Chose column");
    int st=this.scanner.nextInt();
    int rowIndex=row-1;
    int colIndex=st-1;
    if (this.GameField.isPlasefree(rowIndex,colIndex)){
        this.GameField.setValue(rowIndex,colIndex,who);
        this.GameField.PrintField();
        //
    }
    else{
        System.out.println("Wrong number (maybe this is not free?) Make turn");
        turn();
    }
    }
}
