package com.crio.buildoutqa.repository;

import com.crio.buildoutqa.data.ModuleQuestionsEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleQuestionsRepository extends MongoRepository<ModuleQuestionsEntity,String> {

}