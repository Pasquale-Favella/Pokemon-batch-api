package com.pokemon.pokebatch.controller;


import com.pokemon.pokebatch.dto.PokemonListResponse;
import com.pokemon.pokebatch.dto.PokemonPagedResponse;
import com.pokemon.pokebatch.dto.PokemonSingleResponse;

import com.pokemon.pokebatch.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PokemonController {
    
    @Autowired
    PokemonService pokemonService;


    @GetMapping("/pokemon")
    ResponseEntity<PokemonPagedResponse> getAllPaged(
        @RequestParam(required = false, defaultValue = "0") int pageNum , 
        @RequestParam(required = false, defaultValue = "10") int pageSize
    ){

        return new ResponseEntity<>(
            new PokemonPagedResponse(HttpStatus.OK.value(), pokemonService.findAllPaged(pageNum, pageSize)), 
            HttpStatus.OK
        );
        
    }


    @GetMapping("/pokemon/{id}")
    ResponseEntity<PokemonSingleResponse> findById(@PathVariable Integer id){

        return pokemonService.findById(id)
                .map((pokemon)-> new ResponseEntity<>(
                    new PokemonSingleResponse(HttpStatus.OK.value(), pokemon), 
                    HttpStatus.OK
                ))
                .orElseGet(() -> new ResponseEntity<>(
                    new PokemonSingleResponse(HttpStatus.NOT_FOUND.value(), null), 
                    HttpStatus.NOT_FOUND
                ));
        
    }

    @GetMapping("/pokemon/best")
    ResponseEntity<PokemonListResponse> getBest(){
        return new ResponseEntity<>(
            new PokemonListResponse(HttpStatus.OK.value(), pokemonService.findBest()), 
            HttpStatus.OK
        );
    }

    
    
}
