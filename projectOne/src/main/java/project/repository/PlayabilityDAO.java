package project.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import project.domain.Playability;
import project.entity.UserEntity;

@Repository
public class PlayabilityDAO {

	Map<UserEntity, List<Playability>> playabilityUser = new HashMap<>();

	public PlayabilityDAO() {

	}

}
