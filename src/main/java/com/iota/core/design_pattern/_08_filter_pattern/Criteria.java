package com.iota.core.design_pattern._08_filter_pattern;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}