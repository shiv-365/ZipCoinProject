package com.zipcoin.repository;

import com.zipcoin.block.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}