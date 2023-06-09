package org.sid.radarmicroservice.web.grpc.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Définition du service Radar-Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: radarGrpc.proto")
public final class RadarServiceGrpc {

  private RadarServiceGrpc() {}

  public static final String SERVICE_NAME = "RadarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest,
      org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> getProcessRadarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processRadar",
      requestType = org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest.class,
      responseType = org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest,
      org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> getProcessRadarMethod() {
    io.grpc.MethodDescriptor<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest, org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> getProcessRadarMethod;
    if ((getProcessRadarMethod = RadarServiceGrpc.getProcessRadarMethod) == null) {
      synchronized (RadarServiceGrpc.class) {
        if ((getProcessRadarMethod = RadarServiceGrpc.getProcessRadarMethod) == null) {
          RadarServiceGrpc.getProcessRadarMethod = getProcessRadarMethod = 
              io.grpc.MethodDescriptor.<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest, org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RadarService", "processRadar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction.getDefaultInstance()))
                  .setSchemaDescriptor(new RadarServiceMethodDescriptorSupplier("processRadar"))
                  .build();
          }
        }
     }
     return getProcessRadarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RadarServiceStub newStub(io.grpc.Channel channel) {
    return new RadarServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RadarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RadarServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RadarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RadarServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Définition du service Radar-Service
   * </pre>
   */
  public static abstract class RadarServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processRadar(org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest request,
        io.grpc.stub.StreamObserver<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessRadarMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessRadarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest,
                org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction>(
                  this, METHODID_PROCESS_RADAR)))
          .build();
    }
  }

  /**
   * <pre>
   * Définition du service Radar-Service
   * </pre>
   */
  public static final class RadarServiceStub extends io.grpc.stub.AbstractStub<RadarServiceStub> {
    private RadarServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RadarServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RadarServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RadarServiceStub(channel, callOptions);
    }

    /**
     */
    public void processRadar(org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest request,
        io.grpc.stub.StreamObserver<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessRadarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Définition du service Radar-Service
   * </pre>
   */
  public static final class RadarServiceBlockingStub extends io.grpc.stub.AbstractStub<RadarServiceBlockingStub> {
    private RadarServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RadarServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RadarServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RadarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction processRadar(org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessRadarMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Définition du service Radar-Service
   * </pre>
   */
  public static final class RadarServiceFutureStub extends io.grpc.stub.AbstractStub<RadarServiceFutureStub> {
    private RadarServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RadarServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RadarServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RadarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction> processRadar(
        org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessRadarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_RADAR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RadarServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RadarServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_RADAR:
          serviceImpl.processRadar((org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.RadarRequest) request,
              (io.grpc.stub.StreamObserver<org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.Infraction>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RadarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RadarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RadarService");
    }
  }

  private static final class RadarServiceFileDescriptorSupplier
      extends RadarServiceBaseDescriptorSupplier {
    RadarServiceFileDescriptorSupplier() {}
  }

  private static final class RadarServiceMethodDescriptorSupplier
      extends RadarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RadarServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RadarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RadarServiceFileDescriptorSupplier())
              .addMethod(getProcessRadarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
