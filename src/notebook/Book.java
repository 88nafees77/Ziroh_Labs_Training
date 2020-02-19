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
public class Book extends NoteBook{

    private int page;
    private int add_page;

    public Book(int page) {
        super(page);
    }

    public int getAdd_page() {
        return add_page;
    }

    public void setAdd_page(int add_page) {
        this.add_page = add_page;
    }

    public int getPages() {
        return page;
    }

    public void setPages(int pages) {
        this.page = page;
    }

    public void tear_out(int tpage) {

    }

    @Override
    void write(String write) {
        
        if(write==null || no_of_pages==blank_pages){
            System.out.println("page or msg missing");
            return;
        }else{
            System.out.println(write);
            blank_pages++;
            writtenpages++;
          
            
        }
    }

    @Override
    void read() {
        
    }

}
