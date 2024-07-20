package com.example.planner.link;

import com.example.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    LinkRepository repository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip){
        Link newLink = new Link(payload.title(), payload.url(), trip);

        this.repository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

//    public List<ActivityData> getAllActivitiesFromId(UUID tripId ){
//        return this.repository.findByTripId(tripId)
//                .stream()
//                .map(activity -> new ActivityData(
//                        activity.getId(),
//                        activity.getTitle(),
//                        activity.getOccursAt()
//                )).toList();
//    }
}
