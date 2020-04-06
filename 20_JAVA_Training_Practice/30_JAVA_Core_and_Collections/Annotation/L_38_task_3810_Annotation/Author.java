package com.company;

public @interface Author {
    String value() default "";
    Position position() default Position.OTHER;
}
