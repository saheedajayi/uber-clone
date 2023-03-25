package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.CreditCard;
import africa.semicolon.uberClone.data.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
