package com.bit.usr;

import com.bit.book.BookList;
import com.bit.operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 11:27
 */
public abstract class User {
    protected String name;
    protected IOperation[] operations;


    public abstract int menu();
    // 根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
