package com.example.spacexspring;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpacexService {

    public List<Dates> getDates(List<Capsules> posts) {
        return List.of(
                new Dates("How many capsules have been reused?",
                        List.of(String.valueOf(posts.stream().filter(x -> x.getReuse_count() != 0).count()))),
                new Dates("What percentage of capsules land in water?",
                        List.of(Math.round((double) posts.stream().filter(x -> !x.getWater_landings().equals(0)).count()
                                / (double) posts.stream().count() * 100)
                                + "%")),
                new Dates("Percentage of reused capsules?",
                        List.of(Math.round((double) posts.stream().filter(x -> x.getReuse_count() != 0).count()
                                / (double) posts.stream().count() * 100)
                                + "%")),
                new Dates("which reused capsules of type Dragon 2.0 are still active?",
                        posts.stream().filter(x -> x.getReuse_count() != 0
                                        && x.getStatus().equals("active") && x.getType().equals("Dragon 2.0"))
                                .sorted(Comparator.comparingInt(Capsules::getReuse_count).reversed()).map(x -> x.toString()).collect(Collectors.toList())),
                new Dates("Which capsules have been reused?",
                        posts.stream().filter(x -> x.getReuse_count() != 0)
                                .sorted(Comparator.comparingInt(Capsules::getReuse_count).reversed()).map(x -> x.toString()).collect(Collectors.toList()))

        );
    }

}
