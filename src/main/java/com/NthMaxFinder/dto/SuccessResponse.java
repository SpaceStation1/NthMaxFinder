package com.NthMaxFinder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {

    private String code;
    private String description;
    private String message;
    private Integer maxNumber;
}
