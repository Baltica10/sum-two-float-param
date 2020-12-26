package com.stiki.pixels.sumapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    @NotNull
    @JsonProperty("param_one")
    private Float paramOne;

    @NotNull
    @JsonProperty("param_two")
    private Float paramTwo;

    public Map<String, Float> getMapParams(){
        Map<String, Float> result = new HashMap<>();
        result.put("param_one", this.paramOne);
        result.put("param_two", this.paramTwo);

        return result;
    }
}
