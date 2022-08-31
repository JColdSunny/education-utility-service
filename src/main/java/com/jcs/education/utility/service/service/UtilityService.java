package com.jcs.education.utility.service.service;

import com.jcs.education.common.proto.Tag;
import com.jcs.education.utility.service.mapper.UtilityMapper;
import com.jcs.education.utility.service.proto.v1.GetCourseUtilitiesRequest;
import com.jcs.education.utility.service.proto.v1.GetCourseUtilitiesResponse;
import com.jcs.education.utility.service.repository.TagEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.jcs.education.utility.service.service.ValidateGetUtilitiesRequest.validateGetTagsRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UtilityService {
    TagEntityRepository tagRepository;
    UtilityMapper utilityMapper;

    public GetCourseUtilitiesResponse getCourseUtilities(GetCourseUtilitiesRequest request) {
        validateGetTagsRequest(request);

        List<Tag> tags = tagRepository.findAllById(request.getTagIdsList()).stream()
                .map(utilityMapper::toGrpcTag)
                .toList();

        return GetCourseUtilitiesResponse.newBuilder()
                .addAllTags(tags)
                .build();
    }
}
