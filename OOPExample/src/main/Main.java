package main;

import model.Chesspiece;
import model.Pole;
import model.Student;

public class Main {
    public static void main(String[] args) {
        final String TITLE_1 = "peshka1";
        int x1 = 0;
        final String TITLE_2 = "peshka2";

        Chesspiece chesspiecePeshka1 = new Chesspiece(
                "W",
                0,
                2,
                TITLE_1
        );
        Chesspiece chesspiecePeshka2 = new Chesspiece(
                "W",
                1,
                2,
                TITLE_2
        );
        Pole pole1 = new Pole();

        System.out.println(chesspiecePeshka1.getStatus());

        System.out.println(chesspiecePeshka1);
        System.out.println(chesspiecePeshka1.getTitle() + " - " + chesspiecePeshka2.getTitle());
        chesspiecePeshka2.setStatus(false);
        System.out.println(chesspiecePeshka2.getStatus());

        Chesspiece[] chesspieces = {chesspiecePeshka1, chesspiecePeshka2};
        Chess chess = new Chess(chesspieces, pole1);
        chess.play();

        Student luntik = new Student(20, 23432);
    }
}
