package com.stiki.pixels.sumapi.controller;

import com.stiki.pixels.sumapi.dto.*;
import com.stiki.pixels.sumapi.exception.ValidationException;
import com.stiki.pixels.sumapi.service.SumService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

import static com.stiki.pixels.sumapi.util.Constants.*;

@RestController
@RequestMapping(API_V1 + CALC)
public class SumController {
    private final SumService service;

    public SumController(SumService service) {
        this.service = service;
    }

    @ApiOperation("Sum of the provided parameters")
    @PostMapping()
    public ResponseEntity<ResponseDto> sumParameters(@Valid @RequestBody RequestDto dto,
                                                     @ApiIgnore Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException("Validation error!", errors.getFieldErrors());
        }

        return ResponseEntity.ok(service.sumParameters(dto));
    }
}