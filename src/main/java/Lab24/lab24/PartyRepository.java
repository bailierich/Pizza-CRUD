package Lab24.lab24;

import org.springframework.data.jpa.repository.JpaRepository;

import Lab24.lab24.entity.Party;

public interface PartyRepository extends JpaRepository<Party,Long> {

}
