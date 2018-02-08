package com.nhsbsa.finance.requests;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Headers {

  private Map<String, String> headers = new HashMap<>();
}
