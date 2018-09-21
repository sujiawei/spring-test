package com.sujiawei.java.annotation;

import java.lang.annotation.*;
import java.sql.Connection;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TxManagerAnnotation {

    String db() default "";

    int level() default Connection.TRANSACTION_REPEATABLE_READ;

}
