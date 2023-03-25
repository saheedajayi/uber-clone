package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
