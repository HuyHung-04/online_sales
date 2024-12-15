package com.example.shopapp.services;

import com.example.shopapp.dtos.UserDTO;
import com.example.shopapp.exceptions.DataNotFoundException;
import com.example.shopapp.models.User;

public interface IUserService {
    // dang ky
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    // dang nhap kiem tra trong csdl xem co chua
    // de kieu string vi sau nay no se tra ve 1 token key chua thong tin cua cac user da dang nhap
    String login(String phoneNumber, String password);

}
