package com.stiki.pixels.sumapi.dto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RequestDtoTest {

    RequestDto dto = new RequestDto(25.5f, 26.6f);

    @Test
    void setParamOne() {
        dto.setParamOne(null);
        assertNull(dto.getParamOne());

        dto.setParamOne(33f);
        assertEquals(33f, dto.getParamOne());
    }

    @Test
    void setParamTwo() {
        dto.setParamOne(null);
        assertNull(dto.getParamOne());

        dto.setParamOne(44f);
        assertEquals(44f, dto.getParamOne());
    }


    @Test
    void getMapParams() {
        Map<String, Float> testResult = new HashMap<>();
        testResult.put("param_one", 25.5f);
        testResult.put("param_two", 26.6f);

        assertEquals(testResult, dto.getMapParams());
    }

    @Test
    void getParamOne() {
        assertEquals(25.5f, dto.getParamOne());
    }

    @Test
    void getParamTwo() {
        assertEquals(26.6f, dto.getParamTwo());
    }


}