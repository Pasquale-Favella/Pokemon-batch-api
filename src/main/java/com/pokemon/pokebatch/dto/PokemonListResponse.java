package com.pokemon.pokebatch.dto;

import java.util.List;


public class PokemonListResponse extends PokemonBaseResponse<List<PokemonBaseInfo>> {

    public PokemonListResponse(Integer status, List<PokemonBaseInfo> list) {
        super(status, list);
    }
    
}
