package user;

import java.util.concurrent.ConcurrentHashMap;

public class UserInformation implements UserRepository{

  private final ConcurrentHashMap<String, User> hashMap;

  public UserInformation() {
    hashMap = new ConcurrentHashMap<>();
  }

  @Override
  public User findByMsisdn(String msisdn) {
    return hashMap.get(msisdn);
  }

  @Override
  public void updateUserByMsisdn(String msisdn, User user) {
    hashMap.put(msisdn, user);
  }

  public void getInformation() {
    System.out.println(hashMap);
  }
}
