package com.dmadev.service.impl;

import com.dmadev.comparapi.model.UserModel;
import com.dmadev.configuration.ConfigProperties;
import com.dmadev.repository.UserRepository;
import com.dmadev.repository.UserRepositoryImpl;
import com.dmadev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ConfigProperties configProperties;
    private final UserRepository userRepository;

    public List<UserModel> findUser(Long id, String username, String sort, String order) {
        var datasourceList = configProperties.getDatasource();

        List<UserModel> userModels = datasourceList.stream()
                .map(datasource -> userRepository.findUser(datasource, id, username))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return sortUserModels(userModels, sort, order);
    }


    private List<UserModel> sortUserModels(List<UserModel> userModels, String sort, String order) {
        var sortOrder = Objects.nonNull(order) && order.equals("asc") ? "asc" : "desc";

        if (Objects.nonNull(sort)) {
            switch (sort) {
                case "username":
                    var compareByUsername = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getUsername) : Comparator
                            .comparing(UserModel::getUsername).reversed();
                    return userComparator(userModels, compareByUsername);
                case "name":
                    var compareByName = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getName) : Comparator
                            .comparing(UserModel::getName).reversed();
                    return userComparator(userModels, compareByName);
                case "surname":
                    var compareBySurname = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getSurname) : Comparator
                            .comparing(UserModel::getName).reversed();
                    return userComparator(userModels, compareBySurname);
            }
        }

        return userModels;
    }

    private List<UserModel> userComparator(List<UserModel> userModels, Comparator<UserModel> compareBy) {
        return userModels.stream()
                .sorted(compareBy)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
