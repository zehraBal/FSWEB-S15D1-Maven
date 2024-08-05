package org.example.models;

import java.util.*;

public class Grocery {

    public static ArrayList<String> groceryList=new ArrayList<>();


    public static boolean checkItemsInList(String product){
      return groceryList.contains(product);
    }

    public static void addItems(String input){
            String[] items= input.split(",");
            for(String item:items){
                if(!checkItemsInList(item)){
                    groceryList.add(item);
                }
            }
        printSorted();

    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }

    public static  void removeItems(String input){
        String[] items= input.split(",");
      for(String item:items){
          if(checkItemsInList(item)){
              groceryList.remove(item);
          }

      }
        printSorted();
    }


    public void startGrocery(int no){
        if(no==0) {
            System.out.println("İşlem sonlandırıldı.");
        }else if(no==1){
            System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
            Scanner scanner =new Scanner(System.in);
            String input=scanner.nextLine();
            addItems(input);


        }else if(no==2){
            System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
            Scanner scanner =new Scanner(System.in);
            String input=scanner.nextLine();
            removeItems(input);

        }
    }
}
