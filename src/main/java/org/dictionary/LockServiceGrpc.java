package org.dictionary;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: lock.proto")
public final class LockServiceGrpc {

  private LockServiceGrpc() {}

  public static final String SERVICE_NAME = "LockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Lock> getLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lock",
      requestType = org.dictionary.TxnKV.class,
      responseType = org.dictionary.Lock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Lock> getLockMethod() {
    io.grpc.MethodDescriptor<org.dictionary.TxnKV, org.dictionary.Lock> getLockMethod;
    if ((getLockMethod = LockServiceGrpc.getLockMethod) == null) {
      synchronized (LockServiceGrpc.class) {
        if ((getLockMethod = LockServiceGrpc.getLockMethod) == null) {
          LockServiceGrpc.getLockMethod = getLockMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.TxnKV, org.dictionary.Lock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LockService", "lock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.TxnKV.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Lock.getDefaultInstance()))
                  .setSchemaDescriptor(new LockServiceMethodDescriptorSupplier("lock"))
                  .build();
          }
        }
     }
     return getLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Lock> getUnlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unlock",
      requestType = org.dictionary.TxnKV.class,
      responseType = org.dictionary.Lock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Lock> getUnlockMethod() {
    io.grpc.MethodDescriptor<org.dictionary.TxnKV, org.dictionary.Lock> getUnlockMethod;
    if ((getUnlockMethod = LockServiceGrpc.getUnlockMethod) == null) {
      synchronized (LockServiceGrpc.class) {
        if ((getUnlockMethod = LockServiceGrpc.getUnlockMethod) == null) {
          LockServiceGrpc.getUnlockMethod = getUnlockMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.TxnKV, org.dictionary.Lock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LockService", "unlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.TxnKV.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Lock.getDefaultInstance()))
                  .setSchemaDescriptor(new LockServiceMethodDescriptorSupplier("unlock"))
                  .build();
          }
        }
     }
     return getUnlockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LockServiceStub newStub(io.grpc.Channel channel) {
    return new LockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LockServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void lock(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Lock> responseObserver) {
      asyncUnimplementedUnaryCall(getLockMethod(), responseObserver);
    }

    /**
     */
    public void unlock(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Lock> responseObserver) {
      asyncUnimplementedUnaryCall(getUnlockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.TxnKV,
                org.dictionary.Lock>(
                  this, METHODID_LOCK)))
          .addMethod(
            getUnlockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.TxnKV,
                org.dictionary.Lock>(
                  this, METHODID_UNLOCK)))
          .build();
    }
  }

  /**
   */
  public static final class LockServiceStub extends io.grpc.stub.AbstractStub<LockServiceStub> {
    private LockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockServiceStub(channel, callOptions);
    }

    /**
     */
    public void lock(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Lock> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unlock(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Lock> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnlockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LockServiceBlockingStub extends io.grpc.stub.AbstractStub<LockServiceBlockingStub> {
    private LockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.dictionary.Lock lock(org.dictionary.TxnKV request) {
      return blockingUnaryCall(
          getChannel(), getLockMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.dictionary.Lock unlock(org.dictionary.TxnKV request) {
      return blockingUnaryCall(
          getChannel(), getUnlockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LockServiceFutureStub extends io.grpc.stub.AbstractStub<LockServiceFutureStub> {
    private LockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Lock> lock(
        org.dictionary.TxnKV request) {
      return futureUnaryCall(
          getChannel().newCall(getLockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Lock> unlock(
        org.dictionary.TxnKV request) {
      return futureUnaryCall(
          getChannel().newCall(getUnlockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOCK = 0;
  private static final int METHODID_UNLOCK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOCK:
          serviceImpl.lock((org.dictionary.TxnKV) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Lock>) responseObserver);
          break;
        case METHODID_UNLOCK:
          serviceImpl.unlock((org.dictionary.TxnKV) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Lock>) responseObserver);
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

  private static abstract class LockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.dictionary.LockProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LockService");
    }
  }

  private static final class LockServiceFileDescriptorSupplier
      extends LockServiceBaseDescriptorSupplier {
    LockServiceFileDescriptorSupplier() {}
  }

  private static final class LockServiceMethodDescriptorSupplier
      extends LockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LockServiceFileDescriptorSupplier())
              .addMethod(getLockMethod())
              .addMethod(getUnlockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
