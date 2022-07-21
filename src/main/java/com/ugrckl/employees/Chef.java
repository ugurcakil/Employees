package com.ugrckl.employees;

public interface Chef {

    final String favoriteFood = "hamburger";

    default void cook(String food){
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp(){
        return "I'm done cleaning up";
    }

    default String getFavoriteFood(){
        return favoriteFood;
    }


}
