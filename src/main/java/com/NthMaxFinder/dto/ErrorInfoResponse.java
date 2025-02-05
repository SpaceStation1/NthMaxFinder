package com.NthMaxFinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorInfoResponse implements Serializable {

    private String uri;
    private String type;
    private String status;
    private String message;
}
