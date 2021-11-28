package com.daiyu.jpa;

import com.daiyu.jpa.qbe.SexEnum;
import com.daiyu.jpa.qbe.User;
import com.daiyu.jpa.qbe.UserAddress;
import com.daiyu.jpa.qbe.repository.UserAddressRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * Created by dyx on 2021/11/28
 */
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserAddressRepositoryTest {

    @Autowired
    private UserAddressRepository addressRepository;

    private Date now = new Date();

    /**
     * 负责添加数据
     */
    @BeforeAll
    @Rollback(false)
    @Transactional
    void init() {
        User user = User.builder()
                .name("jack")
                .email("12345678qq.com")
                .sex(SexEnum.BOY)
                .age(20)
                .createTime(Instant.now())
                .updateTime(now)
                .build();

        addressRepository.saveAll(Lists.newArrayList(
                UserAddress.builder().user(user).address("shanghai").build(),
                UserAddress.builder().user(user).address("beijing").build()));


    }

    @Test
    @Rollback(false)
    public void testQBEFromUserAddress() throws JsonProcessingException {
        User request = User.builder().name("jack").age(20).email("12345").build();
        UserAddress address = UserAddress.builder().address("shang").user(request).build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("user.email", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Page<UserAddress> all = addressRepository.findAll(Example.of(address, exampleMatcher), PageRequest.of(0, 2));
        
    }

}
