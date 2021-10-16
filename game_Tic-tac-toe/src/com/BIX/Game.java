package com.BIX;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<ChessBoard> winedBoard=new ArrayList<>();
    ChessBoard currentBoard;
    Player a ,b;
    private void fillWinCases(){
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < ChessBoard.MAXSIZE; j++) {
                winedBoard.add(new ChessBoard(i,j));
            }
        }
        winedBoard.add(new ChessBoard(3,1));
        winedBoard.add(new ChessBoard(3,2));
    }
    private boolean checkWin(Player player){
        currentBoard.printBoard();
       for(ChessBoard winCase:winedBoard){
           if(winCase.checkWin(player,currentBoard)){
               System.out.println((char)player.getIdentify()+" win!");
               return true;
           }
        }
       return false;
    }

    Game(){
        System.out.println("Initialize game and set win condition");
        a=new Player('X');
        b=new Player('O');
        currentBoard =new ChessBoard();
        fillWinCases();
    }
    void play(){
        System.out.println("Please play game within 300 steps");
        for(int i=0;i<=300;i++){
            a.step(currentBoard);
            if(checkWin(a)){
                return;
            }
            b.step(currentBoard);
            if(checkWin(b)){
                return;
            }

        }

    }
}
