package africa.semicolon.uberClone.data.dtos.requests;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import static africa.semicolon.uberClone.utils.AppUtils.EMAIL_REGEX_STRING;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterDriverRequest {
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    @Email(message = "email must not be null", regexp = EMAIL_REGEX_STRING)
    private String email;
    @Size(message = "", min = 6, max = 20)
    private String password;
    private MultipartFile licenseImage;
}
