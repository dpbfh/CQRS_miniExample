package at.fhv.cqrs.commands.controller;

import java.util.Collections;
import java.util.Map;

public class Pair {
    // Return an immutable singleton map containing only the specified
    // key-value pair mapping
    public static <T, U> Map<T, U> of(T first, U second)
    {
        return Collections.singletonMap(first, second);
    }
}
