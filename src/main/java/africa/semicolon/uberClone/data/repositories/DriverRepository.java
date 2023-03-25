package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.CreditCard;
import africa.semicolon.uberClone.data.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
