package africa.semicolon.uberClone.data.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterPassengerRequest {
    private String email;
    @JsonProperty("fullName")
    private String name;
    private String password;
}
