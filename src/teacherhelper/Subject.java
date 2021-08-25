/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

/**
 *
 * @author ViSion
 */
public class Subject {
    private String name;
    private int credits;
   Subject(String name,int credits){
       this.name=name;
       this.credits=credits;
   }
   public void setName(String name){
       this.name=name;
   }
   public void setCredits(int Credits){
       this.credits=credits;
   }
   public String getName(){
       return this.name;
   }
   public int getCredits(){
       return this.credits;
   }
}
