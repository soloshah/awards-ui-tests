package com.nhsbsa.finance.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.RequestBodyEntity;
import java.util.Map;

public class Requests {

  public HttpResponse postRequest(String path, Map<String, String> headers, String body) {
    return bodyRequest(Unirest::post, path, headers, body);
  }

  private HttpResponse bodyRequest(RequestType requestType, String url,
      Map<String, String> headers, String body) {
    RequestBodyEntity request = requestType.method(url)
        .headers(headers)
        .body(body);
    requestLogger(request);
    HttpResponse response = null;
    try {
      response = request.asJson();
    } catch (UnirestException e) {
      e.printStackTrace();
    }
    responseLogger(response);
    return response;
  }

  private void requestLogger(BaseRequest request) {
    HttpRequest httpRequest = request.getHttpRequest();
    String requestBody;
    try {
      requestBody = ((RequestBodyEntity) request).getBody().toString();
    } catch (java.lang.ClassCastException e) {
      requestBody = null;
    }
    String log = String.format("\nREQUEST:\nMETHOD: %s\nURL: %s\nHEADERS: %s\nBODY: %s\n",
        httpRequest.getHttpMethod(), httpRequest.getUrl(), httpRequest.getHeaders(), requestBody);
    System.out.println(log);
  }

  private void responseLogger(HttpResponse response) {
    String log = String
        .format("\nRESPONSE:\nSTATUS_CODE: %d\nSTATUS_TEXT: %s\nHEADERS: %s\nBODY: %s\n",
            response.getStatus(), response.getStatusText(), response.getHeaders(),
            response.getBody());
    System.out.println(log);
  }

  private interface RequestType {

    HttpRequestWithBody method(String url);
  }
}
