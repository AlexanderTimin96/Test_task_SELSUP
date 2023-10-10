package ru.selsup;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class CrptApi {
    private final TimeUnit timeUnit;
    private final int requestLimit;

    private final String URI = "https://ismp.crpt.ru/api/v3/lk/documents/create";

    public void createDocument(Document document, String signature) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost(URI);


            httpClient.execute(post);


        } catch (IOException e) {

        }
    }

    @RequiredArgsConstructor
    @Data
    public class Document {
        private final Description description;
        private final String docId;
        private final String docStatus;
        private final String docType;
        private final boolean importRequest;
        private final String ownerInn;
        private final String participantInn;
        private final String producerInn;
        private final Date productionDate;
        private final String productionType;
        private final Product product;
        private final Date regDate;
        private final String regNumber;
    }

    @RequiredArgsConstructor
    @Data
    public class Product {
        private final String certificateDocument;
        private final Date certificateDocumentDate;
        private final String certificateDocumentNumber;
        private final String ownerInn;
        private final String producerInn;
        private final Date productionDate;
        private final String tnvedCode;
        private final String uitCode;
        private final String uituCode;
    }

    @RequiredArgsConstructor
    public class Description {
        private final String participantInn;
    }
}


