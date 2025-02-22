package mos.ecom.service;

import mos.ecom.dto.User;

public interface UserService {
    public void addUser(User user);
    public boolean isHere(String name, String password);

}
