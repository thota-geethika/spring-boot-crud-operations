package com.example.springbootcrudoperations.dto;

import com.example.springbootcrudoperations.model.NewPeer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseDto {
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    //If I give NewPeer, does that make a difference?- I shouldn't expose my entity in DTO.
    //What's the use of DTO then? lol

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> dataList;
}
