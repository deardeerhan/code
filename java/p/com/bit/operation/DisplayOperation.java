package com.bit.operation;

import com.bit.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 11:30
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("DisplayOperation");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
