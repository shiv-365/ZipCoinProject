package com.zipcoin.controllers;

import com.zipcoin.model.Block;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zipcoin.repository.BlockRepository;

import java.util.List;

@RestController
public class BlockController {

    @Autowired
    private BlockRepository blockRepository;

    //CREATE
    @RequestMapping(value = "blocks", method = RequestMethod.POST)
    public ResponseEntity<Block> create(@RequestBody Block block){
        return new ResponseEntity<Block>(blockRepository.saveAndFlush(block),HttpStatus.CREATED);
    }

    //READ
    @RequestMapping(value = "blocks/{id}", method = RequestMethod.GET)
    public Block get(@PathVariable Long id){
        return blockRepository.findOne(id);
    }

    //READ
    @RequestMapping(value = "blocks", method = RequestMethod.GET)
    public List<Block> get(){
        return blockRepository.findAll();
    }

    //UPDATE
    @RequestMapping(value = "blocks/{id}", method = RequestMethod.PUT)
    public Block update(@PathVariable Long id, @RequestBody Block block){
        Block blockToUpdate = blockRepository.findOne(id);
        BeanUtils.copyProperties(block, blockToUpdate);
        return blockRepository.saveAndFlush(blockToUpdate);
    }

    //DELETE
    @RequestMapping(value = "blocks/{id}", method = RequestMethod.DELETE)
    public Block delete(@PathVariable Long id){
        Block blockToDelete = blockRepository.findOne(id);
        blockRepository.delete(blockToDelete);
        return blockToDelete;
    }

}
