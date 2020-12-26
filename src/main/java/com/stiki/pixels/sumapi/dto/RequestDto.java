package com.stiki.pixels.sumapi.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.validation.constraints.NotNull;
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

    @JsonIgnore
    public Map<String, Float> getMapParams() {
        Map<String, Float> result = new HashMap<>();
        result.put("param_one", this.paramOne);
        result.put("param_two", this.paramTwo);

        return result;
    }
}
