package com.acknsyn.hardboard

import org.springframework.context.annotation.*
import org.springframework.boot.autoconfigure.*

import static org.springframework.boot.SpringApplication.run

@Configuration
@ComponentScan
@EnableAutoConfiguration
class Application{
    static void main(args) {
        run(Application, args)
    }
}
