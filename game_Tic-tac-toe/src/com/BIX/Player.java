package com.BIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private int identify;
    void step(ChessBoard board) {
        System.out.println("Hello " + (char)identify + " , please input your mark steps using (x,y):");
        String mark = "";

       do {
           try {
               BufferedReader reader = new BufferedReader(
                   new InputStreamReader(System.in));
               mark = reader.readLine();

           } catch (IOException e) {
               e.printStackTrace(); //todo
           }

       }while(!(mark.matches("\\([0-2],[0-2]\\)")&&board.isEmpty(Integer.parseInt(mark.substring(1,2)) ,
               Integer.parseInt(mark.substring(3,4)))));
        board.setMark(this,Integer.parseInt(mark.substring(1,2)),Integer.parseInt(mark.substring(3,4)));
    }

    Player(int identify){
        this.identify=identify;
    }
    int getIdentify(){
        return identify;
    }
}
