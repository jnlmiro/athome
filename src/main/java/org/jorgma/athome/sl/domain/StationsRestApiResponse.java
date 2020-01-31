package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public class StationsRestApiResponse {

    private int statusCode;
    private String message;
    private long executionTime;
    private List<StationTrafikLab> responseData;


    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    @JsonProperty("ExecutionTime")
    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public List<StationTrafikLab> getResponseData() {
        return responseData;
    }

    @JsonProperty("ResponseData")
    public void setResponseData(List<StationTrafikLab> responseData) {
        this.responseData = responseData;
    }


    @Override
    public String toString() {
        return "StationsRestApiResponse{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", executionTime=" + executionTime +
                ", responseData=" + responseData +
                '}';
    }
}
