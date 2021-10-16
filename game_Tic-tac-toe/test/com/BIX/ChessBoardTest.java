package com.BIX;

import static org.junit.Assert.*;

public class ChessBoardTest {

    @org.junit.Test
    public void chessBoard_winCase_row_fill() {
        ChessBoard board=new ChessBoard(1,0);
        assertEquals(1,board.getMark(0,0));
        assertEquals(1,board.getMark(0,1));
        assertEquals(1,board.getMark(0,2));
    }
    public void chessBoard_winCase_col_fill() {
        ChessBoard board=new ChessBoard(2,0);
        assertEquals(1,board.getMark(1,0));
        assertEquals(1,board.getMark(2,0));
        assertEquals(1,board.getMark(0,0));
    }
    public void chessBoard_winCase_diagonal_leftFill() {
        ChessBoard board=new ChessBoard(3,1);
        assertEquals(1,board.getMark(0,0));
        assertEquals(1,board.getMark(1,1));
        assertEquals(1,board.getMark(2,2));
    }
    public void chessBoard_winCase_diagonal_rightFill() {
        ChessBoard board=new ChessBoard(3,2);
        assertEquals(1,board.getMark(0,2));
        assertEquals(1,board.getMark(1,1));
        assertEquals(1,board.getMark(2,0));
    }
    @org.junit.Test
    public void checkWin() {
        ChessBoard winCase=new ChessBoard(3,2);
        ChessBoard board=new ChessBoard();
        Player a=new Player('A');
        board.setMark(a,0,2);
        board.setMark(a,1,1);
        board.setMark(a,2,0);
        assertTrue(winCase.checkWin(a,board));
        board=new ChessBoard();
        board.setMark(a,0,2);
        board.setMark(a,1,1);
        board.setMark(a,1,0);
        assertFalse(winCase.checkWin(a,board));
    }
}