package su.itschool.guru.web.importproviders.irtech;

import java.util.Comparator;

class SchoolClassesComparator implements Comparator<SchoolClassWrapper> {

    @Override
    public int compare(SchoolClassWrapper o1, SchoolClassWrapper o2) {
        if (o1.getGrade() > o2.getGrade()) return 1;
        if ((o1.getGrade().equals(o2.getGrade())) && (o1.getLetter() > o2.getLetter())) return 1;
        return -1;
    }
}
