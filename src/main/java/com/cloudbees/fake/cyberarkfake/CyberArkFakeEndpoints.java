package com.cloudbees.fake.cyberarkfake;

import com.cloudbees.fake.cyberarkfake.pojos.GetPasswordBody;
import com.cloudbees.fake.cyberarkfake.pojos.LogonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController()
public class CyberArkFakeEndpoints {
  private final static Logger logger = LoggerFactory.getLogger(CyberArkFakeEndpoints.class);

  @PostMapping("/PasswordVault/API/auth/Cyberark/Logon")
  public String logon(@RequestBody LogonBody logonBody) {
    return "{ \"tok123\"}";
  }

  @PostMapping("/PasswordVault/api/Accounts/{accountId}/Password/Retrieve")
  public String getPassword(@PathVariable("accountId") String accountId,
                            @RequestHeader("Authorization") String authorization,
                            @RequestBody GetPasswordBody getPasswordBody) {
    byte[] decodedBytes = Base64.getDecoder().decode(authorization.getBytes());
    String decodedString = new String(decodedBytes);
    logger.info("Decoding authorization header: {}", decodedString);
    return "{\"p4ssw0rd\"}";
  }
}
