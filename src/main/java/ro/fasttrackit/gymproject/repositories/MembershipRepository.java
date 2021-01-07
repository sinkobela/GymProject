package ro.fasttrackit.gymproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.gymproject.domain.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {
}
