package com.jcs.education.tag.service.mapper;

import com.jcs.education.common.proto.Tag;
import com.jcs.education.tag.service.entity.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GetTagsMapper {

    @Mapping(target = "tagId", source = "id")
    Tag toGrpcTag(TagEntity tag);

}
