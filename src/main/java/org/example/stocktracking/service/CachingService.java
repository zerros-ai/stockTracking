package org.example.stocktracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CachingService
{
    @Autowired
    private RedisTemplate redisTemplate;


}
