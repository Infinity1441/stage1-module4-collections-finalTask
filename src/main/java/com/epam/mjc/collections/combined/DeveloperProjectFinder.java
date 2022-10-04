package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> company = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : projects.entrySet()) {
            if (entry.getValue().contains(developer)) {
                company.add(entry.getKey());
            }
        }

        company.sort(Comparator.comparingInt(String::length));
        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length()==o2.length())
                return o1.compareTo(o2);
            return 0;
        };
        company.sort(comparator);
        Collections.reverse(company);
        return company;
    }
}
