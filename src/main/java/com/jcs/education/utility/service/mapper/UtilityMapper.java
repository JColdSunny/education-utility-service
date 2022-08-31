package com.jcs.education.utility.service.mapper;

import com.jcs.education.common.proto.Tag;
import com.jcs.education.utility.service.entity.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UtilityMapper {

    @Mapping(target = "tagId", source = "id")
    Tag toGrpcTag(TagEntity tag);

}
