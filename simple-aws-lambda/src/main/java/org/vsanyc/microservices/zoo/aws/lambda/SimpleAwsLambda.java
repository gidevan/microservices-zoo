package org.vsanyc.microservices.zoo.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleAwsLambda implements RequestHandler<S3Event, String> {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleAwsLambda.class);

    @Override
    public String handleRequest(S3Event input, Context context) {
        LambdaLogger logger = context.getLogger();
        LOG.info("logger. SimpleAwsLambda is started...");
        logger.log("SimpleAwsLambda is started...");
        input.getRecords().stream()
                .map(S3EventNotification.S3EventNotificationRecord::getS3)
                .forEach(s3Entity -> {
                    String key = s3Entity.getObject().getKey();
                    LOG.info("logger. Key: " + key);
                    logger.log("Key: " + key);
                });
        LOG.info("logger. SimpleAwsLambda is completed");
        logger.log("SimpleAwsLambda is completed");
        return "completed";
    }
}
