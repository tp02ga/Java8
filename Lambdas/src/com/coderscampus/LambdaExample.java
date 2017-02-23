package com.coderscampus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import org.junit.Test;

public class LambdaExample
{
  Long id = 0L;
  
  @Test
  public void test ()
  {
    List<Transaction> transactions = new ArrayList<>();
    
    for (int i=0; i<200; i++)
      transactions.add(buildTransaction());
    
    System.out.println(transactions);
    
//    Collections.sort(transactions, new Comparator<Transaction>() {@Override public int compare(Transaction t1, Transaction t2) { return t1.getDate().compareTo(t2.getDate()); }});
//    
//    Collections.sort(transactions, (Transaction t1, Transaction t2) -> {return t1.getDate().compareTo(t2.getDate());});
//    
//    Collections.sort(transactions, (t1, t2) -> {return t1.getDate().compareTo(t2.getDate());});
//    
//    Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
    
   //  A::B   (A = class name, B = method name)
    Collections.sort(transactions, Comparator.comparing(Transaction::getId));
    
    System.out.println(transactions);
  }
  
  private Transaction buildTransaction() 
  {
    id++;
    
    Transaction transaction = new Transaction();
    transaction.setId(id);
    transaction.setAmount(generateRandomAmount());
    
    long millis = ThreadLocalRandom.current().nextLong(1400000000000L, 1500000000000L);
    transaction.setDate(new Date(millis));
    
    return transaction;
  }

  private double generateRandomAmount()
  {
    double amount = ThreadLocalRandom.current().nextDouble() * 1000;
    amount = amount * 100.0;
    amount = Math.round(amount);
    amount = amount / 100.0;
    return amount;
  }
  
}
