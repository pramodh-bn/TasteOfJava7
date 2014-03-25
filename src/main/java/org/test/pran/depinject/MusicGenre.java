package org.test.pran.depinject;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier

public  @interface MusicGenre {
    Genre genre() default  Genre.TRANCE;
    public enum Genre{CLASSICAL, METAL, ROCK, TRANCE}
}


