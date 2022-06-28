package com.github.qx57.tdo_example_java.tdo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qx57.tdo_example_java.tdo.api.dto.ApiRequest;
import com.github.qx57.tdo_example_java.tdo.api.dto.ApiResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;

public class OrderApi {

    private final String path = "http://localhost:4231/order_api";

    @Getter
    private ApiResponse response;
    @Getter
    private Integer statusCode;

    public OrderApi changeStatus(Integer orderId, String newStatus) {
        ApiRequest body = new ApiRequest(orderId, newStatus);
        ObjectMapper mapper = new ObjectMapper();
        String boyJsonString = "";
        try {
            boyJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response rawResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(boyJsonString)
                .when()
                .post(path);
        statusCode = rawResponse.statusCode();
        response = rawResponse.as(ApiResponse.class);
        return this;
    }
}
