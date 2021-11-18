package com.pokemon.pokebatch.repository;

import java.util.List;

import com.pokemon.pokebatch.dto.PokemonBaseInfo;
import com.pokemon.pokebatch.models.Pokemon;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

    @Query(
        nativeQuery = true,
        value=
        "select p.pokedex_number as pokedexnumber , p.base_total as basetotal, p.name , p.generation "
        +"from pokemon as p "
        +"inner join (SELECT  max(d.base_total) base , d.generation  FROM pokemon as d group by d.generation ) as pm on p.generation= pm.generation "
        +"and p.base_total = pm.base "
    )
    List<PokemonBaseInfo> findBestPokemonByGeneration();

    @Query(
        nativeQuery = true,
        value=
        "select p.pokedex_number as pokedexnumber , p.base_total as basetotal, p.name , p.generation "
        +"from pokemon as p "
    )
    List<PokemonBaseInfo> findAllBaseInfos();


    @Query(
        nativeQuery = true,
        value=
        "select p.pokedex_number as pokedexnumber , p.base_total as basetotal, p.name , p.generation "
        +"from pokemon as p ",
        countQuery = "SELECT count(*) FROM POKEMON "
    )
    Page<PokemonBaseInfo> findAllBaseInfosPage(Pageable pageable);
    
}
