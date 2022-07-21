package com.jcs.education.tag.service.service;

import com.jcs.education.tag.service.exception.RequestValidationException;
import com.jcs.education.tag.service.proto.v1.GetTagsRequest;
import org.springframework.util.CollectionUtils;

class ValidateGetTagsRequest {

    private ValidateGetTagsRequest() {
        throw new UnsupportedOperationException("ValidateGetTagsRequest is a static utility class");
    }

    static void validateGetTagsRequest(GetTagsRequest request) {
        if (CollectionUtils.isEmpty(request.getTagIdsList())) {
            throw new RequestValidationException("tag_ids must contain list of tag id");
        }
    }

}
