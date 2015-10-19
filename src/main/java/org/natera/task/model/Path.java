package org.natera.task.model;

import java.util.ArrayList;
import java.util.Collection;

public class Path<T> extends ArrayList<T> {

    public Path(Collection<? extends T> c) {
        super(c);
    }

    public Path() {
    }

    @Override
    public String toString() {
        return this.stream()
                .map(Object::toString)
                .reduce((o, o2) -> (o + "-" + o2))
                .get();
    }

}
