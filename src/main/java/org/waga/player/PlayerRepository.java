package org.waga.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByEmailAddressIsNotNull();

}
