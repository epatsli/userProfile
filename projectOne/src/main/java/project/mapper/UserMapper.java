package project.mapper;

import java.util.List;
import java.util.stream.Collectors;

import project.entity.UserEntity;
import project.to.UserDTO;
import project.to.UserTO;

public class UserMapper {

	public static List<UserDTO> mapUser(List<UserEntity> allUsers) {

		return allUsers.stream().map(u -> mapToDto(u)).collect(Collectors.toList());
	}

	public static UserDTO mapToDto(UserEntity userEntity) {

		return new UserDTO(userEntity.getFirstName(), userEntity.getLastName());
	}

	/*
	 * public static UserDTO mapToDto(UserEntity userEntity) {
	 * 
	 * return new UserDTO(userEntity.getFirstName(), userEntity.getLastName());
	 * }
	 */

	public static List<UserTO> mapUsers(List<UserEntity> allUsers) {

		return allUsers.stream().map(u -> mapToTO(u)).collect(Collectors.toList());
	}

	public static UserTO mapToTO(UserEntity userEntity) {

		return new UserTO(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(),
				userEntity.getEmail());
	}

}
