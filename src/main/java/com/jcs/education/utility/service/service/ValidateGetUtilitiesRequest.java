package com.jcs.education.utility.service.service;

import com.jcs.education.utility.service.exception.RequestValidationException;
import com.jcs.education.utility.service.proto.v1.GetCourseUtilitiesRequest;
import org.springframework.util.CollectionUtils;

class ValidateGetUtilitiesRequest {

    private ValidateGetUtilitiesRequest() {
        throw new UnsupportedOperationException("ValidateGetTagsRequest is a static utility class");
    }

    static void validateGetTagsRequest(GetCourseUtilitiesRequest request) {
        if (CollectionUtils.isEmpty(request.getTagIdsList())) {
            throw new RequestValidationException("tag_ids must contain list of tag id");
        }
    }

}
