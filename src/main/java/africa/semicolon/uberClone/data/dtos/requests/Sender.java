package africa.semicolon.uberClone.data.dtos.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sender {
    private String name;
    private String email;

}
