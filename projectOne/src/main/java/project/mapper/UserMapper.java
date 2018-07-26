package project.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import project.entity.UserEntity;
import project.to.UserTO;

@Component
public class UserMapper {

	public static List<UserTO> mapUsersTO(List<UserEntity> allUsers) {

		return allUsers.stream().map(UserMapper::mapToTO).collect(Collectors.toList());
	}

	public static UserTO mapToTO(UserEntity userEntity) {

		return new UserTO(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(),
				userEntity.getEmail(), userEntity.getPassword(), userEntity.getLifeMotto(),
				userEntity.getPlayability());
	}

	public static List<UserEntity> mapUserToEntity(List<UserTO> allUserTO) {

		return allUserTO.stream().map(UserMapper::mapToEntity).collect(Collectors.toList());
	}

	public static UserEntity mapToEntity(UserTO userTo) {

		return new UserEntity(userTo.getId(), userTo.getFirstName(), userTo.getLastName(), userTo.getEmail(),
				userTo.getPassword(), userTo.getLifeMotto(), userTo.getPlayability());
	}
}
