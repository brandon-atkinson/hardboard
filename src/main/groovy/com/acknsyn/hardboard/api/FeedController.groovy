package com.acknsyn.hardboard.api
import com.acknsyn.hardboard.api.data.Feed
import org.joda.time.DateTime
import org.springframework.hateoas.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
/**
 *
 */
@RestController
@RequestMapping("/api/feed")
class FeedController {

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    HttpEntity<Resource<Feed>> getFeed(@PathVariable("id") String id) {
        Resource<Feed> feed = new Resource<>(new Feed(id:id, updated: new DateTime(), entries: []))
        feed.add(linkTo(FeedController).slash(id).withSelfRel())
        return new ResponseEntity<>(feed, HttpStatus.OK)
    }
}
