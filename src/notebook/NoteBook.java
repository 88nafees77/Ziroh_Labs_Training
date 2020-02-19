/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook;

/**
 *
 * @author nafees
 */
public abstract class NoteBook {  // this is the abstract class for Notebook
                                   //int this abstract class there will two abstract method
                                    //one will be write() and anotther will be read() 

    final int no_of_pages;
    int blank_pages=0;
    int writtenpages=0;

    public NoteBook(int page) {  //this NoteBook Constrctor is for initialized total number of pages should
                                   // available in the NoteBook
        no_of_pages=page;
    }
    
    

    abstract void write(String str); // this write() will take message as string for wrting into the notebook

    abstract void read();
}
