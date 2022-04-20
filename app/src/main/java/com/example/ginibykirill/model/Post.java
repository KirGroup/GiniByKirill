package com.example.ginibykirill.model;

import android.util.Log;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class Post  {
    private List <Object> numbers = new ArrayList<>();

    public Post(List<Object> numbers) {
        this.numbers = numbers;
    }
    public Post() {

    }

    public int[] returnNumbersList(){
      // true - red, false - orange
      int[] resultList = new int[20];

      for(int i = 0; i<resultList.length; i++){
        //num = "numbers":10.0
        resultList[i]= Integer.parseInt(numbers.get(i).toString().substring(8,numbers.get(i).toString().length()-3));;
      }
      return  resultList;
    }

    public void copyNumbers(Post response){
        this.numbers.addAll(response.getNumbers());
    }

    public List<Object> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Object> numbers) {
        this.numbers = numbers;
    }




}
