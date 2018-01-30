package com.gwu.cs6461.services.cpu.ctrlu;

import java.lang.annotation.*;

/**
 * Clock cycle consumed by certain control unit operations
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ClockCycle {
    int FETCH = 1;
    int DECODE = 2;
    int EXECUTE = 3;

    int count() default 1;
}
