package learn_annotation;

import java.lang.annotation.*;

/**
 * java基础学习.
 * Date: 2017/2/17 0017
 * Time: 19:09
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
