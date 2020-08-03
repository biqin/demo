import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class AnnotationFather {
    @JsonSetter("newValue")
    public int extendValue =12;

    @JsonGetter("getValue")
    public int getExtendValue() {
        return extendValue;
    }
}
