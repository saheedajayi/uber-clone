package africa.semicolon.uberClone.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AppUser userDetails;
    private String employeeId;

}
