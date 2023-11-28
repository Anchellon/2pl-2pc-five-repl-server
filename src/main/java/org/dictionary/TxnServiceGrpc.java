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
    comments = "Source: txn.proto")
public final class TxnServiceGrpc {

  private TxnServiceGrpc() {}

  public static final String SERVICE_NAME = "TxnService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Status> getCopyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "copy",
      requestType = org.dictionary.TxnKV.class,
      responseType = org.dictionary.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Status> getCopyMethod() {
    io.grpc.MethodDescriptor<org.dictionary.TxnKV, org.dictionary.Status> getCopyMethod;
    if ((getCopyMethod = TxnServiceGrpc.getCopyMethod) == null) {
      synchronized (TxnServiceGrpc.class) {
        if ((getCopyMethod = TxnServiceGrpc.getCopyMethod) == null) {
          TxnServiceGrpc.getCopyMethod = getCopyMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.TxnKV, org.dictionary.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxnService", "copy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.TxnKV.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new TxnServiceMethodDescriptorSupplier("copy"))
                  .build();
          }
        }
     }
     return getCopyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.dictionary.Txn,
      org.dictionary.Status> getDoCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doCommit",
      requestType = org.dictionary.Txn.class,
      responseType = org.dictionary.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.Txn,
      org.dictionary.Status> getDoCommitMethod() {
    io.grpc.MethodDescriptor<org.dictionary.Txn, org.dictionary.Status> getDoCommitMethod;
    if ((getDoCommitMethod = TxnServiceGrpc.getDoCommitMethod) == null) {
      synchronized (TxnServiceGrpc.class) {
        if ((getDoCommitMethod = TxnServiceGrpc.getDoCommitMethod) == null) {
          TxnServiceGrpc.getDoCommitMethod = getDoCommitMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.Txn, org.dictionary.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxnService", "doCommit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Txn.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new TxnServiceMethodDescriptorSupplier("doCommit"))
                  .build();
          }
        }
     }
     return getDoCommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.dictionary.Txn,
      org.dictionary.Status> getDoAbortMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doAbort",
      requestType = org.dictionary.Txn.class,
      responseType = org.dictionary.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.Txn,
      org.dictionary.Status> getDoAbortMethod() {
    io.grpc.MethodDescriptor<org.dictionary.Txn, org.dictionary.Status> getDoAbortMethod;
    if ((getDoAbortMethod = TxnServiceGrpc.getDoAbortMethod) == null) {
      synchronized (TxnServiceGrpc.class) {
        if ((getDoAbortMethod = TxnServiceGrpc.getDoAbortMethod) == null) {
          TxnServiceGrpc.getDoAbortMethod = getDoAbortMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.Txn, org.dictionary.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxnService", "doAbort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Txn.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new TxnServiceMethodDescriptorSupplier("doAbort"))
                  .build();
          }
        }
     }
     return getDoAbortMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.dictionary.KeyValue,
      org.dictionary.Status> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = org.dictionary.KeyValue.class,
      responseType = org.dictionary.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.KeyValue,
      org.dictionary.Status> getGetMethod() {
    io.grpc.MethodDescriptor<org.dictionary.KeyValue, org.dictionary.Status> getGetMethod;
    if ((getGetMethod = TxnServiceGrpc.getGetMethod) == null) {
      synchronized (TxnServiceGrpc.class) {
        if ((getGetMethod = TxnServiceGrpc.getGetMethod) == null) {
          TxnServiceGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.KeyValue, org.dictionary.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxnService", "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.KeyValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new TxnServiceMethodDescriptorSupplier("get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Status> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = org.dictionary.TxnKV.class,
      responseType = org.dictionary.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.dictionary.TxnKV,
      org.dictionary.Status> getDeleteMethod() {
    io.grpc.MethodDescriptor<org.dictionary.TxnKV, org.dictionary.Status> getDeleteMethod;
    if ((getDeleteMethod = TxnServiceGrpc.getDeleteMethod) == null) {
      synchronized (TxnServiceGrpc.class) {
        if ((getDeleteMethod = TxnServiceGrpc.getDeleteMethod) == null) {
          TxnServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<org.dictionary.TxnKV, org.dictionary.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxnService", "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.TxnKV.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.dictionary.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new TxnServiceMethodDescriptorSupplier("delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TxnServiceStub newStub(io.grpc.Channel channel) {
    return new TxnServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TxnServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TxnServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TxnServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TxnServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TxnServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void copy(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getCopyMethod(), responseObserver);
    }

    /**
     */
    public void doCommit(org.dictionary.Txn request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getDoCommitMethod(), responseObserver);
    }

    /**
     */
    public void doAbort(org.dictionary.Txn request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getDoAbortMethod(), responseObserver);
    }

    /**
     */
    public void get(org.dictionary.KeyValue request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void delete(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCopyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.TxnKV,
                org.dictionary.Status>(
                  this, METHODID_COPY)))
          .addMethod(
            getDoCommitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.Txn,
                org.dictionary.Status>(
                  this, METHODID_DO_COMMIT)))
          .addMethod(
            getDoAbortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.Txn,
                org.dictionary.Status>(
                  this, METHODID_DO_ABORT)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.KeyValue,
                org.dictionary.Status>(
                  this, METHODID_GET)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.dictionary.TxnKV,
                org.dictionary.Status>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class TxnServiceStub extends io.grpc.stub.AbstractStub<TxnServiceStub> {
    private TxnServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxnServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxnServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxnServiceStub(channel, callOptions);
    }

    /**
     */
    public void copy(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCopyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void doCommit(org.dictionary.Txn request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDoCommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void doAbort(org.dictionary.Txn request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDoAbortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(org.dictionary.KeyValue request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(org.dictionary.TxnKV request,
        io.grpc.stub.StreamObserver<org.dictionary.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TxnServiceBlockingStub extends io.grpc.stub.AbstractStub<TxnServiceBlockingStub> {
    private TxnServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxnServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxnServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxnServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.dictionary.Status copy(org.dictionary.TxnKV request) {
      return blockingUnaryCall(
          getChannel(), getCopyMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.dictionary.Status doCommit(org.dictionary.Txn request) {
      return blockingUnaryCall(
          getChannel(), getDoCommitMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.dictionary.Status doAbort(org.dictionary.Txn request) {
      return blockingUnaryCall(
          getChannel(), getDoAbortMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.dictionary.Status get(org.dictionary.KeyValue request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.dictionary.Status delete(org.dictionary.TxnKV request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TxnServiceFutureStub extends io.grpc.stub.AbstractStub<TxnServiceFutureStub> {
    private TxnServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxnServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxnServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxnServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Status> copy(
        org.dictionary.TxnKV request) {
      return futureUnaryCall(
          getChannel().newCall(getCopyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Status> doCommit(
        org.dictionary.Txn request) {
      return futureUnaryCall(
          getChannel().newCall(getDoCommitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Status> doAbort(
        org.dictionary.Txn request) {
      return futureUnaryCall(
          getChannel().newCall(getDoAbortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Status> get(
        org.dictionary.KeyValue request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.dictionary.Status> delete(
        org.dictionary.TxnKV request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COPY = 0;
  private static final int METHODID_DO_COMMIT = 1;
  private static final int METHODID_DO_ABORT = 2;
  private static final int METHODID_GET = 3;
  private static final int METHODID_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TxnServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TxnServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COPY:
          serviceImpl.copy((org.dictionary.TxnKV) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Status>) responseObserver);
          break;
        case METHODID_DO_COMMIT:
          serviceImpl.doCommit((org.dictionary.Txn) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Status>) responseObserver);
          break;
        case METHODID_DO_ABORT:
          serviceImpl.doAbort((org.dictionary.Txn) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Status>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((org.dictionary.KeyValue) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Status>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((org.dictionary.TxnKV) request,
              (io.grpc.stub.StreamObserver<org.dictionary.Status>) responseObserver);
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

  private static abstract class TxnServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TxnServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.dictionary.TxnProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TxnService");
    }
  }

  private static final class TxnServiceFileDescriptorSupplier
      extends TxnServiceBaseDescriptorSupplier {
    TxnServiceFileDescriptorSupplier() {}
  }

  private static final class TxnServiceMethodDescriptorSupplier
      extends TxnServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TxnServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TxnServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TxnServiceFileDescriptorSupplier())
              .addMethod(getCopyMethod())
              .addMethod(getDoCommitMethod())
              .addMethod(getDoAbortMethod())
              .addMethod(getGetMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
