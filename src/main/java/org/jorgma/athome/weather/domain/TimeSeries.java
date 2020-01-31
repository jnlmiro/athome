package org.jorgma.athome.weather.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jorgma.athome.serializers.LocalDateTimeDeserializer;
import org.jorgma.athome.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jorgma on 2018-02-20.
 */
public class TimeSeries {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime validTime;

    private List<Parameter> parameters;

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
