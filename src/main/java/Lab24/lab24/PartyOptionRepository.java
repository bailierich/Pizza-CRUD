package Lab24.lab24;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import Lab24.lab24.entity.Party;
import Lab24.lab24.entity.PartyOption;

public interface PartyOptionRepository extends JpaRepository<PartyOption,Long> {

	
	List<PartyOption> findByPartyId(Long id);
		List<PartyOption> findByPartyIdAndVotesGreaterThan(Long id, int i);

}