package com.dailydoodle.doodle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydoodle.doodle.repository.DoodleRepository;

@Service
public class DoodleServiceImpl implements DoodleService {

    @Autowired
    private DoodleRepository doodleRepo;

}
