package com.example.demo.service;

import com.example.demo.dto.UserRequestRegisterDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserMysqlRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Date;

import static com.example.demo.utils.DateUtils.convertStringToDate;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMysqlRepository mysqlRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       var user =  mysqlRepository.findByUsername(username);
       if (!user.isPresent()){
           throw new UsernameNotFoundException("not found user");
       }
       return user.get();
    }

    public void createUser(UserRequestRegisterDto requestRegisterDto) throws Exception {
        var user =  mysqlRepository.findByUsername(requestRegisterDto.getUsername());
        if(!user.isPresent()){
           var userEntity =  modelMapper.map(requestRegisterDto, UserEntity.class);
            userEntity.setPassword(passwordEncoder.encode(requestRegisterDto.getPassword()));
            userEntity.setRole("ROLE_USER");
            userEntity.setCreateDate(new Date());
            userEntity.setNonExpired(true);
            userEntity.setEnabled(true);
            userEntity.setNonLocked(true);
            userEntity.setDateOfBirth(convertStringToDate(requestRegisterDto.getBirthday()));
            mysqlRepository.save(userEntity);
        }
        throw new Exception("The email has already existed!");
    }


}
