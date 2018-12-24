package com.tencent.angel.serving.service.common

import com.tencent.angel.serving.apis.prediction.ClassificationProtos.{ClassificationRequest, ClassificationResponse}
import com.tencent.angel.serving.apis.prediction.GetModelMetadataProtos.{GetModelMetadataRequest, GetModelMetadataResponse}
import com.tencent.angel.serving.apis.prediction.InferenceProtos.{MultiInferenceRequest, MultiInferenceResponse}
import com.tencent.angel.serving.apis.prediction.PredictProtos.{PredictRequest, PredictResponse}
import com.tencent.angel.serving.apis.prediction.RegressionProtos.{RegressionRequest, RegressionResponse}
import com.tencent.angel.serving.apis.prediction._
import com.tencent.angel.serving.core.ServerCore
import com.tencent.angel.serving.servables.angel._
import com.tencent.angel.serving.servables.common._
import io.grpc.stub.StreamObserver
import org.slf4j.{Logger, LoggerFactory}


class PredictionServiceImpl extends PredictionServiceGrpc.PredictionServiceImplBase {

  private val LOG: Logger = LoggerFactory.getLogger(classOf[PredictionServiceImpl])
  private var serverCore: ServerCore = _

  def this(serverCore: ServerCore) {
    this()
    this.serverCore = serverCore
  }

  override def predict(request: PredictRequest, responseObserver: StreamObserver[PredictResponse]): Unit = {
    val runOptions = new RunOptions()
    val responseBuilder = PredictResponse.newBuilder()
    val start = System.currentTimeMillis
    ServiceImpl.predict(runOptions, serverCore, request, responseBuilder)
    val predictResponse = responseBuilder.build()
    responseObserver.onNext(predictResponse)
    responseObserver.onCompleted()
    LOG.info("Finished prediction with {} ms", System.currentTimeMillis - start)
  }

  override def classify(request: ClassificationRequest, responseObserver: StreamObserver[ClassificationResponse]): Unit = {
    val runOptions = new RunOptions()
    val responseBuilder = ClassificationResponse.newBuilder()
    ServiceImpl.classify(runOptions, serverCore, request, responseBuilder)
    val classificationResponse = responseBuilder.build()
    responseObserver.onNext(classificationResponse)
    responseObserver.onCompleted()
  }

  override def regress(request: RegressionRequest, responseObserver: StreamObserver[RegressionResponse]): Unit = {
    val runOptions = new RunOptions()
    val responseBuilder = RegressionResponse.newBuilder()
    ServiceImpl.regress(runOptions, serverCore, request, responseBuilder)
    val regressionResponse = responseBuilder.build()
    responseObserver.onNext(regressionResponse)
    responseObserver.onCompleted()
  }

  override def multiInference(request: MultiInferenceRequest, responseObserver: StreamObserver[MultiInferenceResponse]): Unit = {
    val runOptions = new RunOptions()
    val responseBuilder = MultiInferenceResponse.newBuilder()
    ServiceImpl.multiInference(runOptions, serverCore, request, responseBuilder)
    val multiInferenceResponse = responseBuilder.build()
    responseObserver.onNext(multiInferenceResponse)
    responseObserver.onCompleted()
  }

  override def getModelMetadata(request: GetModelMetadataRequest, responseObserver: StreamObserver[GetModelMetadataResponse]): Unit = {
    val responseBuilder = GetModelMetadataResponse.newBuilder()
    ServiceImpl.modelMetaData(serverCore, request, responseBuilder)
    val getModelMetadataResponse = responseBuilder.build()
    responseObserver.onNext(getModelMetadataResponse)
    responseObserver.onCompleted()
  }

}