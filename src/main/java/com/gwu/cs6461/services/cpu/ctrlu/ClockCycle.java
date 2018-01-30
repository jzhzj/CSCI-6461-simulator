package com.gwu.cs6461.services.cpu.ctrlu;

import java.lang.annotation.*;

/**
 * Clock cycle consumed by certain control unit operations
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ClockCycle {
    int count() default 1;
}
