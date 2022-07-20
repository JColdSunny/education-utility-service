package com.jcs.education.tag.service.service;

import com.jcs.education.common.proto.Tag;
import com.jcs.education.tag.service.mapper.GetTagsMapper;
import com.jcs.education.tag.service.proto.v1.GetTagsRequest;
import com.jcs.education.tag.service.proto.v1.GetTagsResponse;
import com.jcs.education.tag.service.repository.TagEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagService {
    TagEntityRepository tagRepository;
    GetTagsMapper getTagsMapper;

    public GetTagsResponse getTags(GetTagsRequest request) {
        //TODO: validations

        List<Tag> tags = tagRepository.findAllById(request.getTagIdsList()).stream()
                .map(getTagsMapper::toGrpcTag)
                .toList();

        return GetTagsResponse.newBuilder()
                .addAllTags(tags)
                .build();
    }
}
