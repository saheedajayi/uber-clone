package africa.semicolon.uberClone.data.dtos.responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterResponse {
    private Long id;
    private String message;
    private int code;
    private boolean isSuccessful;

}
