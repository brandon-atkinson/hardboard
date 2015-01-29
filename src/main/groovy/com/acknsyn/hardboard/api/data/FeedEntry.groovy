package com.acknsyn.hardboard.api.data
import org.joda.time.DateTime
import org.springframework.hateoas.Identifiable

/**
 *
 */
class FeedEntry implements Identifiable<String> {
    String id
    DateTime updated
    String description
}
