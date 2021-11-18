package com.pokemon.pokebatch.repository;

import java.util.List;

import com.pokemon.pokebatch.models.PokemonAbility;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonAbilityRepo extends JpaRepository<PokemonAbility,Integer>{

    List<PokemonAbility> findByPokedexNum(Integer pokedexNum);
    
}
