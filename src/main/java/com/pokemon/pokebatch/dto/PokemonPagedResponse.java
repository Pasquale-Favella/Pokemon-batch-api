package com.pokemon.pokebatch.dto;

import org.springframework.data.domain.Page;

public class PokemonPagedResponse extends PokemonBaseResponse<Page<PokemonBaseInfo>>{

    public PokemonPagedResponse(Integer status, Page<PokemonBaseInfo> payload) {
        super(status, payload);
    }
    
}
