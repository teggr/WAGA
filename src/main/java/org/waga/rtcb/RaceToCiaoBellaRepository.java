package org.waga.rtcb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceToCiaoBellaRepository extends JpaRepository<RaceToCiaoBella, Long> {

	RaceToCiaoBella findFirstByOrderBySeasonDesc();

}
