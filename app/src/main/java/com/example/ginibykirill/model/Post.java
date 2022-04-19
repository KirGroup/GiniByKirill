package com.example.ginibykirill.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Post {
    private List <Object> numbers = new ArrayList<>();

    public Post(List<Object> numbers) {
        this.numbers = numbers;
    }
    public Post() {

    }

    public Map<Integer,Boolean> returnNumbersList(){
      // true - red, false - orange
      Map<Integer,Boolean> resultList = new HashMap<>();

      int currentVal;

      for(Object num : numbers){
        //num = "numbers":10.0
        Log.i("App121212", num.toString().substring(8,num.toString().length()-3));
        currentVal = Integer.parseInt(num.toString().substring(8,num.toString().length()-3));
        resultList.put(currentVal, false);
        Log.i("App121212", currentVal +"");


      }
      int currentKey;
      boolean currentValue;
      for (Map.Entry<Integer, Boolean> entry : resultList.entrySet()){
          currentKey = entry.getKey();
          if(currentKey==0){
              resultList.put(currentKey, true);
          }
          else {
              currentValue = resultList.containsKey(-1 * currentKey);
              resultList.put(currentKey, currentValue);
//              resultList.put(-1 * currentKey, currentValue);
          }
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
