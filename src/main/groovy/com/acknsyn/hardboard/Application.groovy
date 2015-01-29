package com.acknsyn.hardboard

import org.springframework.context.annotation.*
import org.springframework.boot.autoconfigure.*
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

import static org.springframework.boot.SpringApplication.run

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories
class Application{
    static void main(args) {
        run(Application, args)
    }
}
