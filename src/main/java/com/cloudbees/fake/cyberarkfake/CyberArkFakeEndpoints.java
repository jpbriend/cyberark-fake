package com.cloudbees.fake.cyberarkfake;

import com.cloudbees.fake.cyberarkfake.exception.ForbiddenException;
import com.cloudbees.fake.cyberarkfake.pojos.Credential;
import com.cloudbees.fake.cyberarkfake.pojos.GetPasswordBody;
import com.cloudbees.fake.cyberarkfake.pojos.LogonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CyberArkFakeEndpoints {
  private final static Logger logger = LoggerFactory.getLogger(CyberArkFakeEndpoints.class);

  private Map<String, Credential> accounts;

  public CyberArkFakeEndpoints() {
    this.accounts = new HashMap<String, Credential>();
    accounts.put("cb", new Credential("cb", "passw0rd", "eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJjYiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJjYi10b2tlbi1za2d3biIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJjYiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6ImU0ZTViOWMzLWFmYzEtMTFlYS05NmQwLWZhMTYzZTUzMzFmZiIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpjYjpjYiJ9.oR-ZirDc5e3bxwzY87g1RH89I-9y21AG1FIauDQAzTnXrhVFUvpHjc39FLzG1EVR5UnS0z0XUA1vM15VUjQqU0Zjt_LbY1-oXGbb1xZN7Z3ZVt1T0Pdnvy8sQSNf3nzN9cKQtyUEoUJex6E_k-E1vexgwVAKIOYiL6A9MLNfM90DT_z062SwCZT_5PSSKpBPcZ18P0AWHADZEin72mm9NtvqshXZoXZlG43CyCB6Bw7zXuCw_zqNbcxtK7K5BmJUP9lko5hoW9uVI760C2vyh0H1Q2YiKhtzDyCuSpvFgbUmIQS3x_fVXpIN0tnq4Sr8RZlbSU9tjDj0lq5sCrmvzA"));
    accounts.put("test", new Credential("test", "test", "tok123"));
  }

  @PostMapping("/PasswordVault/API/auth/Cyberark/Logon")
  public String logon(@RequestBody LogonBody logonBody) throws ForbiddenException {
    if (accounts.containsKey(logonBody.getUsername()) && accounts.get(logonBody.getUsername()).getPassword().equals(logonBody.getPassword())) {
      return new String(Base64.getEncoder().encode(accounts.get(logonBody.getUsername()).getLogin().getBytes()));
    } else {
      throw new ForbiddenException("The request requires user authentication.");
    }
  }

  @PostMapping("/PasswordVault/api/Accounts/{accountId}/Password/Retrieve")
  public String getPassword(@PathVariable("accountId") String accountId,
                            @RequestHeader("Authorization") String authorization,
                            @RequestBody GetPasswordBody getPasswordBody) throws ForbiddenException {
    byte[] decodedBytes = Base64.getDecoder().decode(authorization.getBytes());
    String decodedString = new String(decodedBytes);
    if (accounts.containsKey(decodedString)) {
      logger.info("Decoding authorization header: {}", decodedString);
      return accounts.get(decodedString).getToken();
    } else {
      throw new ForbiddenException("The request requires user authentication.");
    }
  }
}
