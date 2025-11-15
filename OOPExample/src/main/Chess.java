package main;

import model.Chesspiece;
import model.Pole;

public class Chess {
    private Chesspiece[] chesspieces;
    private Pole pole;

    public Chess(Chesspiece[] chesspieces, Pole pole) {
        this.chesspieces = chesspieces;
        this.pole = pole;
    }

    public Chess(Pole pole) {
        this.pole = pole;
    }

    public Chess() {}

    public void play() {

    };
}
