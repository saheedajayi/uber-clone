package africa.semicolon.uberClone.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    private String profileImage;
//    @Transient
//    private MultipartFile profileImage;
//    private LocalDateTime createdAt;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private Set<Role> roles;
    private String createdAt;
    private boolean isEnabled;
}
