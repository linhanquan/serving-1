// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: apis/prediction/prediction_service.proto

package com.tencent.angel.serving.apis.prediction;

public final class PredictionServiceProtos {
  private PredictionServiceProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(apis/prediction/prediction_service.pro" +
      "to\022\rangel.serving\032(apis/prediction/get_m" +
      "odel_metadata.proto\032\035apis/prediction/req" +
      "uest.proto\032\036apis/prediction/response.pro" +
      "to2\360\002\n\021PredictionService\022;\n\010Classify\022\026.a" +
      "ngel.serving.Request\032\027.angel.serving.Res" +
      "ponse\022:\n\007Regress\022\026.angel.serving.Request" +
      "\032\027.angel.serving.Response\022:\n\007Predict\022\026.a" +
      "ngel.serving.Request\032\027.angel.serving.Res" +
      "ponse\022A\n\016MultiInference\022\026.angel.serving." +
      "Request\032\027.angel.serving.Response\022c\n\020GetM" +
      "odelMetadata\022&.angel.serving.GetModelMet" +
      "adataRequest\032\'.angel.serving.GetModelMet" +
      "adataResponseBF\n)com.tencent.angel.servi" +
      "ng.apis.predictionB\027PredictionServicePro" +
      "tosP\000b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tencent.angel.serving.apis.prediction.GetModelMetadataProtos.getDescriptor(),
          com.tencent.angel.serving.apis.prediction.RequestProtos.getDescriptor(),
          com.tencent.angel.serving.apis.prediction.ResponseProtos.getDescriptor(),
        }, assigner);
    com.tencent.angel.serving.apis.prediction.GetModelMetadataProtos.getDescriptor();
    com.tencent.angel.serving.apis.prediction.RequestProtos.getDescriptor();
    com.tencent.angel.serving.apis.prediction.ResponseProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
