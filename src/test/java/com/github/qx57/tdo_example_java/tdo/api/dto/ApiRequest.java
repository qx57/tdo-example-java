package com.github.qx57.tdo_example_java.tdo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRequest {

    private Integer order_id;
    private String new_status;
}
