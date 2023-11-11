package any.thing.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="cae", enableByDefault = true)
public class CustomActuatorEndpoint {

    @ReadOperation
    public CustomActuatorEndpointResponse call() {
        return new CustomActuatorEndpointResponse(2023, "cae-resp", "Active");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CustomActuatorEndpointResponse {
        private Integer id;
        private String name;
        private String status;
    }
}
