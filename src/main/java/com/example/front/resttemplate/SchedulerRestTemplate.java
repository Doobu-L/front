package com.example.front.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class SchedulerRestTemplate extends RestTemplate {

  private final String schedulerApi="http://localhost:9000";


  public <T> ResponseEntity<T> get(String url, HttpHeaders httpHeaders, Class<T> clazz) {
    return this.exchange(url, HttpMethod.GET, null, httpHeaders, clazz);
  }

  public <T> ResponseEntity<T> post(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
    return this.exchange(url, HttpMethod.POST, body, httpHeaders, clazz);
  }

  public <T> ResponseEntity<T> put(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
    return this.exchange(url, HttpMethod.PUT, body, httpHeaders, clazz);
  }

  public <T> ResponseEntity<T> delete(String url, HttpHeaders httpHeaders, Class<T> clazz) {
    return this.delete(url, httpHeaders, null, clazz);
  }

  public <T> ResponseEntity<T> delete(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
    return this.exchange(url, HttpMethod.DELETE, body, httpHeaders, clazz);
  }

  private <T> ResponseEntity<T> exchange(String url, HttpMethod method, Object body, HttpHeaders httpHeaders, Class<T> clazz) {
    if(httpHeaders == null)
      httpHeaders = new HttpHeaders();
    httpHeaders.set("Accept", "application/json; charset=utf-8");
    httpHeaders.set("Content-Type", "application/json; charset=utf-8");
    return this.exchange(url, method, new HttpEntity<>(body, httpHeaders), clazz);
  }

  @Override
  public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
      Class<T> responseType, Object... uriVariables) throws RestClientException {
    return super.exchange(schedulerApi+url, method, requestEntity, responseType, uriVariables);
  }

}
