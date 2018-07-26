package project.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entity.GameEntity;
import project.mapper.GameMapper;
import project.mapper.UserMapper;
import project.repository.UserGameDAO;
import project.to.GameTO;
import project.to.UserTO;

@Service
public class UserGameService {

	private UserGameDAO userGameDAO;

	@Autowired
	public UserGameService(UserGameDAO userGameDAO) {
		this.userGameDAO = userGameDAO;
	}

	public List<GameTO> getUserGame(UserTO userTO) throws Exception {

		Set<GameEntity> gameUser = userGameDAO.returnListGame(UserMapper.mapToEntity(userTO));
		return GameMapper.mapGameTO(gameUser);
	}

	public List<GameTO> deleteGame(UserTO user, GameTO game) throws Exception {
		Set<GameEntity> gameUser = userGameDAO.deleteGame(UserMapper.mapToEntity(user), GameMapper.mapToEntity(game));
		return GameMapper.mapGameTO(gameUser);
	}

	public List<GameTO> addGame(UserTO user, GameTO game) throws Exception {
		Set<GameEntity> gameUser = userGameDAO.addNewGame(UserMapper.mapToEntity(user), GameMapper.mapToEntity(game));
		return GameMapper.mapGameTO(gameUser);

	}

	/*
	 * public Set<String> returnListGame(String name) throws Exception { return
	 * userGameDAO.returnListGame(name); }
	 * 
	 * public void deleteGame(String userName, String nameGame) throws Exception
	 * { userGameDAO.deleteGame(userName, nameGame); }
	 * 
	 * public void addNewGame(String userName, String nameGame) throws Exception
	 * { userGameDAO.addNewGame(userName, nameGame); }
	 */
}
