package africa.semicolon.uberClone.data.dtos.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Recipient {
    private String name;
    private String email;
}
