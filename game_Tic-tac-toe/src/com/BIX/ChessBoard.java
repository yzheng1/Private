package com.BIX;

public class ChessBoard {
    public static final int MAXSIZE=3;
    int[][] status =new int[MAXSIZE][MAXSIZE];

    ChessBoard(){
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {
                status[i][j]=0;
            }
        }
    }

    /**
     * fill board with initial value
     * @param direction: row 1, col:2 ,diagonal 3
     * @param number line seq for row/col, left diagonal:1 ,right diagonal :2
     */
    ChessBoard(int direction,int number){
        this();
       switch (direction){
           case 1:
               for (int i = 0; i < MAXSIZE; i++) {
                   status[number][i]=1;
               }
               break;
           case 2:
               for (int i = 0; i < MAXSIZE; i++) {
                   status[i][number]=1;
               }
               break;
           case 3:
               if(number==1){
                   for (int i = 0; i < MAXSIZE; i++) {
                       status[i][i]=1;
                   }
               }else{
                   for (int i = 0; i < MAXSIZE; i++) {
                       status[i][MAXSIZE-i-1]=1;
                   }
               }
       }
    }
    void printBoard(){
      for(int i=0;i<MAXSIZE*2;i++){
          System.out.print('-');
      }
        System.out.println('-');
      for (int i = 0; i < MAXSIZE; i++) {
          for (int j = 0; j < MAXSIZE; j++) {
              System.out.print("-");
              System.out.print((char) status[i][j]);
          }
          System.out.println('-');
      }
        for(int i=0;i<MAXSIZE*2;i++){
            System.out.print('-');
        }
        System.out.println('-');
    }
    void setMark(Player player, int x,int y){
        status[x][y]=player.getIdentify();
    }
    int getMark(int x,int y){
        return status[x][y];
    }
    boolean isEmpty(int x,int y){
        return status[x][y]==0;
    }
    boolean checkWin(Player player,ChessBoard target){
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++) {
                if(status[i][j]!=0 && target.getMark(i,j)!=player.getIdentify()) {
                    return false;
                }
            }
        }
        return true;
    }

}
