package com.acknsyn.hardboard
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.core.env.Environment

@Slf4j
@Configuration
@ComponentScan
@EnableAutoConfiguration
class Application{
    private static final DEFAULT_PROFILE = "local"
    private static final DEV_PHASE_ENVVAR = "_env"

    static void main(args) {
        String devPhase = System.getenv(DEV_PHASE_ENVVAR)
        if (!devPhase) {
            log.info("Setting active profile to default profile ${DEFAULT_PROFILE}")
            devPhase = DEFAULT_PROFILE
        } else {
            log.info("Setting active profile to ${devPhase} by environoment variable ${DEV_PHASE_ENVVAR}")
        }
        System.properties['spring.profiles.active'] = devPhase
        System.properties[DEV_PHASE_ENVVAR] = devPhase

        SpringApplication application = new SpringApplicationBuilder(Application.class).showBanner(false)
                .logStartupInfo(true).registerShutdownHook(true).application()

        application.addListeners(new ApplicationListener<ContextRefreshedEvent>() {
            @Override
            void onApplicationEvent(ContextRefreshedEvent event) {
                Environment environment = event.applicationContext.environment
                log.info("application context refreshed with active profiles: [{}]", environment.activeProfiles)
            }
        })

        application.run(args)
    }
}
