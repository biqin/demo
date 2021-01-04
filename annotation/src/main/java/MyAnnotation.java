import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation在反射函数中的使用示例
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
    int qq() default 23;
}