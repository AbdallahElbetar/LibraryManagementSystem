package com.library.model;




public  abstract    class User implements Borrowable {
   // Encapsulation
     private  String name ;
     private  int  id ;

    // Constructor
    public User(String name, int id){
        this.name=name;
        this.id=id;
    }
    //getters
    public String getName(){
        return  name;
    }
    int getId(){
        return  id;
    }

    // Abstract method (Abstraction)
    public abstract void displayInfo();

}
