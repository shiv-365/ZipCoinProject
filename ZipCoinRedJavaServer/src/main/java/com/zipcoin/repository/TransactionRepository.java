package com.zipcoin.repository;

import com.zipcoin.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    @Query("SELECT t FROM transaction t WHERE t.sender = :publicKey OR t.recipient = :publicKey")
//    List<Transaction> findAllTransactionsWithPubKey(@Param("publicKey") String publicKey);

}
