package com.stiki.pixels.sumapi.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseDtoTest {

    ResponseDto dto = new ResponseDto(55.5);

    @Test
    void getResult() {
        assertEquals(55.5, dto.getResult());
    }

    @Test
    void setResult() {
        dto.setResult(66.85);
        assertEquals(66.85, dto.getResult());
    }

    @Test
    void isResultDouble() {
        assertEquals(true, dto.getResult() instanceof Double);
    }
}