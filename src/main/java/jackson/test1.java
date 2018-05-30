package jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import java.io.IOException;

/**
 * Created by Administrator on 2018/5/31.
 */
public class test1 {
    public static void main(String[] args){

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

            //map json to student
            try {
                Student student = mapper.readValue(jsonString, Student.class);
                System.out.println(student);


                //mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
                jsonString = mapper.writeValueAsString(student);
                System.out.println(jsonString);

            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


class Student {
    private String name;
    private int age;
    public Student(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
