package africa.semicolon.uberClone.data.repositories;

import africa.semicolon.uberClone.data.models.CreditCard;
import africa.semicolon.uberClone.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
