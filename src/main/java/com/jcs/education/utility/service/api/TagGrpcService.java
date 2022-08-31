package com.jcs.education.utility.service.api;

import com.jcs.education.utility.service.proto.v1.EducationUtilityServiceGrpc;
import com.jcs.education.utility.service.proto.v1.GetCourseUtilitiesRequest;
import com.jcs.education.utility.service.proto.v1.GetCourseUtilitiesResponse;
import com.jcs.education.utility.service.service.UtilityService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagGrpcService extends EducationUtilityServiceGrpc.EducationUtilityServiceImplBase {
    UtilityService utilityService;

    @Override
    public void getCourseUtilities(GetCourseUtilitiesRequest request, StreamObserver<GetCourseUtilitiesResponse> responseObserver) {
        GetCourseUtilitiesResponse response = utilityService.getCourseUtilities(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
