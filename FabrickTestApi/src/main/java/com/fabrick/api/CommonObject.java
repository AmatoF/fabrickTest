package com.fabrick.api;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonObject implements Serializable {

    private static final long serialVersionUID = 1681300439161303878L;

    protected final transient Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String toString() {
        String result = "";
        try {
            List exclude = new ArrayList<>();
            result = ReflectionToStringBuilder.toStringExclude(this, exclude);
        } catch (Exception e) {
            logger.error("Error during object conversion : {}", e.getMessage(), e);
        }
        return result;
    }

}
