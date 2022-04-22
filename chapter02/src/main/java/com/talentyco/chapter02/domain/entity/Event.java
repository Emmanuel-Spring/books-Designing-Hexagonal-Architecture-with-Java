package com.talentyco.chapter02.domain.entity;

import com.talentyco.chapter02.domain.policy.RegexEventParser;
import com.talentyco.chapter02.domain.policy.SplitEventParser;
import com.talentyco.chapter02.domain.vo.Activity;
import com.talentyco.chapter02.domain.vo.EventId;
import com.talentyco.chapter02.domain.vo.ParsePolicyType;
import com.talentyco.chapter02.domain.vo.Protocol;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private OffsetDateTime timestamp;
    private EventId id;
    private Protocol protocol;
    private Activity activity;

    public Event(OffsetDateTime timestamp, EventId id, Protocol protocol, Activity activity) {
        this.timestamp = timestamp;
        this.id = id;
        this.protocol = protocol;
        this.activity = activity;
    }

    public static Event parsedEvent(String unparsedEvent, ParsePolicyType policy) {
        switch (policy) {
            case REGEX:
                return new RegexEventParser().parseEvent(unparsedEvent);
            case SPLIT:
                return new SplitEventParser().parseEvent(unparsedEvent);
            default:
                throw new IllegalArgumentException("");
        }
    }

    @Override
    public int compareTo(Event event) {
        return timestamp.compareTo(event.timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
           Event event = (Event) obj;
           return (event.timestamp.equals(this.timestamp)
                   && event.id.equals(this.id)
                   && event.protocol.equals(this.protocol)
                   && event.activity.equals(this.activity)
           );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, id, protocol, activity) + 31;
    }
}