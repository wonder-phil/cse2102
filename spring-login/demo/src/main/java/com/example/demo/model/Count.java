package com.example.demo.model;

public class Count implements java.io.Serializable {
  private int value = 0;

  public int getCount() { 
        return value; 
  }
  public void inc() { value++; }

}

