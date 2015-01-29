package com.acknsyn.hardboard.api.data

import org.joda.time.DateTime
import org.springframework.hateoas.Identifiable
/**
 *
 */
class Feed implements Identifiable<String> {
    String id
    DateTime updated
    List<FeedEntry> entries
}
