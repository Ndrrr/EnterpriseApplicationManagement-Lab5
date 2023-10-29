package com.ndrrr.mssubtract.controller;

import com.ndrrr.mssubtract.client.SumClient;
import com.ndrrr.mssubtract.dto.request.MathOperationRequest;
import com.ndrrr.mssubtract.dto.response.MathOperationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtract")
@RequiredArgsConstructor
public class SubtractController {

    private final SumClient sumClient;

    @PostMapping
    public MathOperationResponse subtract(@RequestBody @Valid MathOperationRequest request) {
        request.sumToSubtraction();
        return sumClient.sum(request);
    }

}
