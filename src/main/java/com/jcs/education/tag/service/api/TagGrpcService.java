package com.jcs.education.tag.service.api;

import com.jcs.education.tag.service.proto.v1.EducationTagServiceGrpc;
import com.jcs.education.tag.service.proto.v1.GetTagsRequest;
import com.jcs.education.tag.service.proto.v1.GetTagsResponse;
import com.jcs.education.tag.service.service.TagService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagGrpcService extends EducationTagServiceGrpc.EducationTagServiceImplBase {
    TagService tagService;

    @Override
    public void getTags(GetTagsRequest request, StreamObserver<GetTagsResponse> responseObserver) {
        GetTagsResponse response = tagService.getTags(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
