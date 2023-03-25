package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInformationRepository extends JpaRepository<BankInformation, Long> {
}
