package com.bayviewglen.chess;

public class Queen {
	int[] rowCol = new int[2];
	
	public Queen(int x, int y){
		rowCol[0]=x;
		rowCol[1]=y;
	}
	public int getCol(){
		return rowCol[0];
	}
	public int getRow(){
		return rowCol[1];
	}
	public void setCol(int x){
		rowCol[0]=x;
	}
	public void setRow(int y){
		rowCol[1]=y;
	}
}
