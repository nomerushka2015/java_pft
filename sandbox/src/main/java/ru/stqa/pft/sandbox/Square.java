package ru.stqa.pft.sandbox;

/**
 * Created by Nastya Nomerovskaya on 28.03.2017.
 */
public class Square {
  public  double l;
  public Square( double len){
    this.l = len;
  }

  public  double area(){
    return this.l * this.l;
  }
}
