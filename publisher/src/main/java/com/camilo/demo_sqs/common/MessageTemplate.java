package com.camilo.demo_sqs.common;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class MessageTemplate {

    final protected Map<String, String> data = new HashMap<String, String>();

}
