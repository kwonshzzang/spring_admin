package kr.co.kwonshzzang.springadmin.service;

import kr.co.kwonshzzang.springadmin.ifs.CRUDInterface;
import kr.co.kwonshzzang.springadmin.model.entity.User;
import kr.co.kwonshzzang.springadmin.model.network.Header;
import kr.co.kwonshzzang.springadmin.model.network.request.UserApiRequest;
import kr.co.kwonshzzang.springadmin.model.network.response.UserApiResponse;
import kr.co.kwonshzzang.springadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CRUDInterface<UserApiRequest, UserApiResponse> {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        // 1. request data
        UserApiRequest userApiRequest = request.getData();
        // 2. user 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> UserApiResponse 리턴
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // 1. id -> repository getOne, getById
        // 2. user -> userApiResponse return
       return userRepository.findById(id)
               .map(user -> response(user))
               .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // 1. get data
        UserApiRequest userApiRequest = request.getData();
        // 2. id -> user 데이터를 찾고
        // 4. return userApiResponse
        return userRepository.findById(userApiRequest.getId())
                .map(user -> {
                            // 3. update
                            user.setAccount(userApiRequest.getAccount())
                                .setPassword(userApiRequest.getPassword())
                                .setStatus(userApiRequest.getStatus())
                                .setPhoneNumber(userApiRequest.getPhoneNumber())
                                .setEmail(userApiRequest.getEmail())
                                .setRegisteredAt(userApiRequest.getRegisteredAt())
                                .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                            return user;
                        })
                .map(user -> userRepository.save(user))  //update
                .map(user -> response(user)) //userApiResponse
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user) {
        // user -> UserApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())  //todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();
        return Header.OK(userApiResponse);
    }
}
