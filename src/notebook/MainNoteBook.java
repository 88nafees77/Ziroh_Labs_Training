/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook;

import java.util.Scanner;

/**
 *
 * @author nafees
 */
public class MainNoteBook {

    public static void main(String[] args) {
       Book p=new Book(4); // we will create a object by passsing value anything which will be pages for notebook
       Scanner sc=new Scanner(System.in); 
       while(true)
       p.write(sc.next()); //here we call write method for wrting into the notebook
       
    }
}
