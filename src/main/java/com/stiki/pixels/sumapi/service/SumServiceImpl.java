package com.stiki.pixels.sumapi.service;

import com.stiki.pixels.sumapi.dto.*;
import com.stiki.pixels.sumapi.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SumServiceImpl implements SumService {

    @Override
    public ResponseDto sumParameters(RequestDto dto) {
        log.info("Get parameters: One:{} Two:{}", dto.getParamOne(), dto.getParamTwo());

        validateParam(dto.getMapParams());

        Double result = dto.getParamOne().doubleValue() + dto.getParamTwo().doubleValue();

        log.info("One + Two = {}", result);

        return new ResponseDto(result);
    }

    private void validateParam(Map<String, Float> params) {
        params.forEach((key, value) -> {
            if (value > Float.MAX_VALUE || value < Float.MIN_VALUE) {
                throw new ValidationException("Value " + key +
                        " must be in the range from " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
            }
        });
    }
}
