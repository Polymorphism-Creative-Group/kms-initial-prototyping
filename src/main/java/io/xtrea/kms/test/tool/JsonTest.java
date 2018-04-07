package io.xtrea.kms.test.tool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.MalformedURLException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonPointer;
import javax.json.JsonValue;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class JsonTest {

     public static void main(String[] args) throws MalformedURLException, IOException {
          JsonObjectBuilder job = Json.createObjectBuilder();
          JsonObject o = job.add("key1", "value1").build();
          JsonObject p = job.add("key2", "value2").build();
          JsonObject q = job.add("key3", "value3").build();

          JsonArray a = Json.createArrayBuilder().add(o).add(p).add(q).build();
          System.out.println(a.toString());
          a.stream().map(JsonValue::asJsonObject)
                  .filter(jo -> "value1".equals(jo.getString("key1", null)))
                  .forEach((x) -> System.out.println(x));
          JsonPointer jp = Json.createPointer("/key1");
          JsonObject o1 = jp.replace(o, Json.createValue("value1-1"));
          System.out.println(o);
          System.out.println(o1);
          System.out.println(o.getValue("/key1"));
     }
}
