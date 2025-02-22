package mos.ecom.service.impl;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.User;
import mos.ecom.entity.UserEntity;
import mos.ecom.repository.UserRepository;
import mos.ecom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final ModelMapper mapper;


    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public boolean isHere(String name, String password) {
        return repository.findByNameAndPassword(name, password) != null;
    }

}
