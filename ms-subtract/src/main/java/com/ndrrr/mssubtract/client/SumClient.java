package com.ndrrr.mssubtract.client;

import com.ndrrr.mssubtract.dto.request.MathOperationRequest;
import com.ndrrr.mssubtract.dto.response.MathOperationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "sum-client",
        url = "${service.sum.url}",
        contextId = "sum-client")
public interface SumClient {

    @PostMapping("/sum")
    MathOperationResponse sum(@RequestBody MathOperationRequest request);

}
