package com.monolith.example.author.impl.domain.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class AuthorService {
    @Value("${simple.dima}")
    private String value;
}
