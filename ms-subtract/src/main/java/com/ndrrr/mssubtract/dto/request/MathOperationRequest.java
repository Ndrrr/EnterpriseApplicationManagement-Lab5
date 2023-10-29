package com.ndrrr.mssubtract.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MathOperationRequest {

    @NotNull
    private Long a;

    @NotNull
    private Long b;

    public void sumToSubtraction() {
        this.b = -this.b;
    }

}
