package ru.yandex.practicum.mapper;

import lombok.Data;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.NewUserUpdate;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.User;

@Data
public class UserMapper {

    public static User mapToUser(NewUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User updateUser(User user, NewUserUpdate request) {
        if (request.hasName()) {
            user.setName(request.getName());
        }

        if (request.hasEmail()) {
            user.setEmail(request.getEmail());
        }

        return user;
    }
}
