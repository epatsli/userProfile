package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.mapper.GameMapper;
import project.mapper.UserMapper;
import project.repository.GameEntity;
import project.repository.UserGameDAO;

@Service
public class UserGameService {

	private UserGameDAO userGameDAO;

	@Autowired
	public UserGameService(UserGameDAO userGameDAO) {
		this.userGameDAO = userGameDAO;
	}

	public List<GameTO> getUserGame(UserTO userTO) throws Exception {

		List<GameEntity> gameUser = userGameDAO.returnListGame(UserMapper.mapToEntity(userTO));
		return GameMapper.mapGameTO(gameUser);
	}

	public List<GameTO> deleteGame(UserTO user, GameTO game) throws Exception {
		List<GameEntity> gameUser = userGameDAO.deleteGame(UserMapper.mapToEntity(user), GameMapper.mapToEntity(game));
		return GameMapper.mapGameTO(gameUser);
	}

	public List<GameTO> addGame(UserTO user, GameTO game) throws Exception {
		List<GameEntity> gameUser = userGameDAO.addNewGame(UserMapper.mapToEntity(user), GameMapper.mapToEntity(game));
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
