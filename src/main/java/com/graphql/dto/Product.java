package com.graphql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record Product(Integer id, String name, String category, Float price, Integer stock) {

}
