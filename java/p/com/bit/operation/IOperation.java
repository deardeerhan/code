package com.bit.operation;

import com.bit.book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-16
 * Time: 11:53
 */
public interface IOperation {
    Scanner scanner = new Scanner(System.in);
    void work(BookList bookList);
}
