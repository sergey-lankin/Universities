package comparators;

import org.apache.commons.lang3.StringUtils;
import resources.University;

public class UniversityIdComparator implements UniversityComparator {

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getId(), university2.getId());
    }
}
