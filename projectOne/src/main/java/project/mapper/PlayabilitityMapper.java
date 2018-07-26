package project.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import project.entity.PlayabilityEntity;
import project.to.PlayabilityTO;

@Component
public class PlayabilitityMapper {
	public static List<PlayabilityTO> mapPlayabilityTO(List<PlayabilityEntity> listPlayability) {

		return listPlayability.stream().map(PlayabilitityMapper::mapToTO).collect(Collectors.toList());
	}

	public static PlayabilityTO mapToTO(PlayabilityEntity playabilityEntity) {

		return new PlayabilityTO(playabilityEntity.getStartDate(), playabilityEntity.getEndDate(),
				playabilityEntity.getComment());
	}

	public static List<PlayabilityEntity> mapPlayabilityToEntity(List<PlayabilityTO> playabilityTO) {

		return playabilityTO.stream().map(PlayabilitityMapper::mapToEntity).collect(Collectors.toList());
	}

	public static PlayabilityEntity mapToEntity(PlayabilityTO availability) {

		return new PlayabilityEntity(availability.getStartDate(), availability.getEndDate(), availability.getComment());
	}
}
