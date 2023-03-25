package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
