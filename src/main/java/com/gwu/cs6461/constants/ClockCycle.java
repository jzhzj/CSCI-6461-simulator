package com.gwu.cs6461.constants;

import java.lang.annotation.*;

/**
 * Clock cycle consumed by certain control unit operations
 *  1 machine cycle = 12 clock cycle
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ClockCycle {
    int FETCH = 6;
    int DECODE = 12;
    int EXECUTE = 6;

    int count() default 1;
}
