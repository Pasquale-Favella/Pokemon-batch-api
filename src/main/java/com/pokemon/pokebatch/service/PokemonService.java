package com.pokemon.pokebatch.service;

import java.util.List;
import java.util.Optional;

import com.pokemon.pokebatch.dto.PokemonBaseInfo;
import com.pokemon.pokebatch.models.Pokemon;
import com.pokemon.pokebatch.repository.PokemonAbilityRepo;
import com.pokemon.pokebatch.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    PokemonAbilityRepo pokemonAbilityRepo;


    public Page<PokemonBaseInfo> findAllPaged(int page , int size){
        return pokemonRepository.findAllBaseInfosPage(PageRequest.of(page, size));
    }

    public Optional<Pokemon> findById(Integer id){

        return pokemonRepository.findById(id).
                map((pokemon)-> {
                    pokemon.setAbility(pokemonAbilityRepo.findByPokedexNum(id));
                    return pokemon;
                });
    }

    public List<PokemonBaseInfo> findBest(){
        return pokemonRepository.findBestPokemonByGeneration();
    }


    
}
