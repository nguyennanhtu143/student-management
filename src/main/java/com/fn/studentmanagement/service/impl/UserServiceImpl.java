package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.user.UpdateUserRequest;
import com.fn.studentmanagement.dto.user.UserRequest;
import com.fn.studentmanagement.dto.user.UserResponse;
import com.fn.studentmanagement.entity.User;
import com.fn.studentmanagement.exception.user.UserNotFoundException;
import com.fn.studentmanagement.exception.user.UsernameExistedException;
import com.fn.studentmanagement.repository.UserRepository;
import com.fn.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  @Transactional
  public UserResponse create(UserRequest request) {
    log.info("(create) user request: {}", request);

    if (this.existedByUsername(request.getUsername())) {
      throw new UsernameExistedException();
    }

    return this.toResponse(repository.save(this.toEntity(request)));
  }

  @Override
  public UserResponse find(Integer id) {
    log.info("(find) user id: {}", id);

    return this.toResponse(this.get(id));
  }

  @Override
  @Transactional
  public UserResponse update(
        Integer id,
        UpdateUserRequest request
  ) {
    log.info("(update) user id: {} request: {}", id, request);

    User user = this.get(id);
    if (this.isModified(user, request)) {
      return this.toResponse(
            repository.save(this.applyChange(user, request))
      );
    }

    return this.toResponse(user);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    log.info("(delete) user id: {}", id);

    repository.delete(this.get(id));
  }

  @Override
  public boolean exist(Integer id) {
    log.info("(exist) user id: {}", id);

    return this.repository.existsById(id);
  }

  private boolean existedByUsername(String username) {
    User user = repository.findByUsername(username);
    return user != null;
  }

  private User toEntity(UserRequest request) {
    return new User(
          request.getUsername(),
          request.getPassword(),
          request.getCode(),
          request.getName(),
          request.getDateOfBirth(),
          request.getAddress(),
          request.getPhone(),
          request.getRole(),
          request.getDepartmentId()
    );
  }

  private UserResponse toResponse(User user) {
    return UserResponse.of(
          user.getId(),
          user.getUsername(),
          user.getPassword(),
          user.getCode(),
          user.getName(),
          user.getDateOfBirth(),
          user.getAddress(),
          user.getPhone(),
          user.getRole(),
          user.getDepartmentId()
    );
  }

  private User get(Integer id) {
    return repository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  private boolean isModified(User user, UpdateUserRequest request) {
    if (!request.getPassword().equals(user.getPassword())) {
      return true;
    }
    if (!request.getName().equals(user.getName())) {
      return true;
    }
    if (!request.getDateOfBirth().equals(user.getDateOfBirth())) {
      return true;
    }
    if (!request.getAddress().equals(user.getAddress())) {
      return true;
    }
    return !request.getPhone().equals(user.getPhone());
  }

  private User applyChange(User user, UpdateUserRequest request) {
    user.setPassword(request.getPassword());
    user.setName(request.getName());
    user.setDateOfBirth(request.getDateOfBirth());
    user.setAddress(request.getAddress());
    user.setPhone(request.getPhone());
    return user;
  }
}
