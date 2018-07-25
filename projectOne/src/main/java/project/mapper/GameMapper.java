package project.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import project.entity.GameEntity;
import project.to.GameTO;

public class GameMapper {

	public static List<GameTO> mapGame(Set<GameEntity> allGame) {

		return allGame.stream().map(u -> mapToTO(u)).collect(Collectors.toList());
	}

	public static GameTO mapToTO(GameEntity gameEntity) {

		return new GameTO(gameEntity.getName());
	}

}
