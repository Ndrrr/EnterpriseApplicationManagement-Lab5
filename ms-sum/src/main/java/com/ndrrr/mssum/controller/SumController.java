package com.ndrrr.mssum.controller;

import com.ndrrr.mssum.dto.request.MathOperationRequest;
import com.ndrrr.mssum.dto.response.MathOperationResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sum")
public class SumController {

    @PostMapping
    public MathOperationResponse sum(@RequestBody @Valid MathOperationRequest request) {
        return MathOperationResponse.of(request.getA() + request.getB());
    }

}
