package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
