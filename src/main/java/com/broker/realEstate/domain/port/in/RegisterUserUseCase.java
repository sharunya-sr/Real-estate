package com.broker.realEstate.domain.port.in;

import com.broker.realEstate.domain.entity.User;

public interface RegisterUserUseCase {

    void registerUser(final User user);
}
