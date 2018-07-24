package project.mapper;

import java.util.List;
import java.util.stream.Collectors;

import project.entity.UserEntity;
import project.to.UserDTO;

public class UserMapper {

	public static List<UserDTO> mapUser(List<UserEntity> allUsers) {

		return allUsers.stream().map(u -> mapToDto(u)).collect(Collectors.toList());
	}

	public static UserDTO mapToDto(UserEntity userEntity) {

		return new UserDTO(userEntity.getFirstName(), userEntity.getLastName());
	}

}
