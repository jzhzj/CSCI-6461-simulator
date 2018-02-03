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
    /**
     * clock cycles consumed by a fetch action takes 6 clock cycles
     * @return clock cycles consumed
     */
    int fetch() default 6;
    /**
     * clock cycles consumed by a decode action
     * @return clock cycles consumed
     */
    int decode() default 12;
    /**
     * clock cycles consumed by an execute action
     * @return clock cycles consumed
     */
    int execute() default 12;
}
