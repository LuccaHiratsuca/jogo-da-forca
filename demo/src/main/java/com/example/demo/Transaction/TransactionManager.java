package com.example.demo.Transaction;

public interface TransactionManager {

	<T> T doInTransaction(TransactionCode<T> code);

}


