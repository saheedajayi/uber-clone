package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
