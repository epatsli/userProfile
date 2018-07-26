package project.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import project.entity.GameEntity;
import project.to.GameTO;

@Component
public class GameMapper {

	public static List<GameTO> mapGameTO(Set<GameEntity> allGame) {

		return allGame.stream().map(GameMapper::mapTO).collect(Collectors.toList());
	}

	public static GameTO mapTO(GameEntity gameEntity) {

		return new GameTO(gameEntity.getName(), gameEntity.getNumberPlayer());
	}

	public static Set<GameEntity> mapGameToEntity(List<GameTO> allGame) {

		return (Set<GameEntity>) allGame.stream().map(GameMapper::mapToEntity).collect(Collectors.toList());
	}

	public static GameEntity mapToEntity(GameTO gameTo) {

		return new GameEntity(gameTo.getName(), gameTo.getNumberPlayer());
	}

}
