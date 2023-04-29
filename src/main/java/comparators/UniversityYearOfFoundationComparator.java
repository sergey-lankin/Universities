package ru.skillfactory.comparators;

import ru.skillfactory.resources.University;

public class UniversityYearOfFoundationComparator implements UniversityComparator {
    @Override
    public int compare(University university1, University university2) {
        return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
    }
}
