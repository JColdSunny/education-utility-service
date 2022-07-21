package com.jcs.education.tag.service.exception.handler;

import com.google.rpc.Status;
import com.jcs.education.tag.service.exception.RequestValidationException;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

import static com.google.rpc.Code.INVALID_ARGUMENT_VALUE;

@GrpcAdvice
public class GrpcErrorHandler {

    @GrpcExceptionHandler(RequestValidationException.class)
    public StatusRuntimeException handleValidationException(RequestValidationException e) {
        Status errorStatus = Status.newBuilder()
                .setCode(INVALID_ARGUMENT_VALUE)
                .setMessage(e.getMessage())
                .build();
        return StatusProto.toStatusRuntimeException(errorStatus);
    }
}
