package com.acknsyn.hardboard.web
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
/**
 *
 */
@RestController
class BuildInfoController {
    @Value("#{environment['info.build.number']}")
    String build

    @RequestMapping(value = "/build-info", method = RequestMethod.GET)
    Map buildInfo() {
        String instance
        try {
            instance = new URL('http://169.254.169.254/latest/meta-data/instance-id').getText()
        } catch (e) {
            instance = InetAddress.getLocalHost().hostName
        }
        return [instance:instance, build:build]
    }
}
