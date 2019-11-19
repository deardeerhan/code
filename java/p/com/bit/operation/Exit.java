package com.bit.operation;

import com.bit.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 11:31
 */
public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("byebye!");
        System.exit(0);
    }
}
