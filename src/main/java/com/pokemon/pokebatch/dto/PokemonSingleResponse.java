package com.pokemon.pokebatch.dto;

import com.pokemon.pokebatch.models.Pokemon;

public class PokemonSingleResponse extends PokemonBaseResponse<Pokemon>{

    public PokemonSingleResponse(Integer status, Pokemon payload) {
        super(status, payload);
    }
    
}
