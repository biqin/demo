import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
//        commonTest();
//        parserTest();
//        generatorTest();
        rwAnnoTest();
    }

    private static void commonTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5, \"date\": \"2012-12-11\" }";

        String carsJson = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        String carNestedJson = "{ \"brand\" : {\"dd\": \"Mercedes\"}, \"doors\" : 5 }";


        System.out.println("============Json to object");
        Car car = objectMapper.readValue(carJson, Car.class);
        System.out.println(car);

        List<Car> cars = objectMapper.readValue(carsJson, new TypeReference<List<Car>>() {
        });
        System.out.println(cars);

        Map<String, Object> carMap = objectMapper.readValue(carNestedJson, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(carMap);

        System.out.println("============object to json");
        String jsonCar = objectMapper.writeValueAsString(car);
        System.out.println(jsonCar);

        String jsonCars = objectMapper.writeValueAsString(cars);
        System.out.println(jsonCars);

        String jsonCarMap = objectMapper.writeValueAsString(carMap);
        System.out.println(jsonCarMap);

        System.out.println("============Json to jsonNode");
        JsonNode jsonNode1 = objectMapper.readTree(carJson);
        System.out.println(jsonNode1);

        JsonNode jsonNode2 = objectMapper.readTree(carsJson);
        System.out.println(jsonNode2);

        JsonNode jsonNode3 = objectMapper.readTree(carNestedJson);
        System.out.println(jsonNode3);

        System.out.println("============JsonNode to json");
        String car1 = objectMapper.writeValueAsString(jsonNode1);
        System.out.println(car1);

        System.out.println("============object to jsonNode");
        System.out.println(objectMapper.valueToTree(car));
        System.out.println(objectMapper.valueToTree(cars));
        System.out.println(objectMapper.valueToTree(carMap));

        System.out.println("============jsonNode to object");
        System.out.println(objectMapper.treeToValue(jsonNode1, Car.class));

        System.out.println("============jsonNode getField");
        System.out.println(jsonNode3.get("brand"));
        System.out.println(jsonNode3.at("/brand/dd").asText());

        System.out.println("============create jsonNode");
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("test", 12);
        objectNode.set("qq", jsonNode1);
        System.out.println(objectNode);
    }


    private static void parserTest() throws IOException {
        String carJson = "{ \"brand\" : {\"dd\": \"Mercedes\"}, \"doors\" : 5 }";
        //String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5, \"date\": \"2012-12-11\" }";
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(carJson);

        Car car = new Car();
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();
            System.out.println(jsonToken + ":" + parser.getCurrentName());

//            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
//                String fieldName = parser.getCurrentName();
//                //System.out.println(fieldName);
//
//                jsonToken = parser.nextToken();
//
//                if ("brand".equals(fieldName)) {
//                    car.setBrand(parser.getValueAsString());
//                } else if ("doors".equals(fieldName)) {
//                    car.setDoors(parser.getValueAsInt());
//                } else if ("date".equals(fieldName)) {
//                    car.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(parser.getValueAsString()));
//                }
//            }
        }

        System.out.println(car);
    }

    private static void generatorTest() throws IOException {
        JsonFactory factory = new JsonFactory();

        JsonGenerator generator = factory.createGenerator(
                new File("D://output.json"), JsonEncoding.UTF8);

        generator.writeStartObject();
        generator.writeStringField("brand", "Mercedes");
        generator.writeNumberField("doors", 5);
        generator.writeEndObject();

        generator.close();
    }

    private static void rwAnnoTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String annoTestJson =
                "{ \"personId\" : 123, \"firstName\" : \"1111\", \"lastName\": \"2222\", \"address\": \"addr\", \"nonIgnore\": \"haha\", \"newValue\": 234}";

        System.out.println("============Json to object");
        System.out.println(objectMapper.readValue(annoTestJson, AnnotationObject.class));

        AnnotationObject annotationObject = AnnotationObject.builder().personId(123).firstName("123").lastName("222").nonIgnore("hehe")
                .build();
        System.out.println("============Object to json");
        System.out.println(annotationObject);
        System.out.println(objectMapper.writeValueAsString(annotationObject));
    }
}
