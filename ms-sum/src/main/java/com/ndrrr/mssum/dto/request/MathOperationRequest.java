package com.ndrrr.mssum.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MathOperationRequest {

    @NotNull
    private Long a;

    @NotNull
    private Long b;

}
