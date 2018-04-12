/*
 * Copyright 2018 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.xtrea.kms.test.jena;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import io.xtrea.kms.test.jena.model.Clazz;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;

/**
 * Examples from https://jena.apache.org/tutorials/rdf_api.html.
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Jena_FreeMarker {

    public static Logger _logger = Logger.getGlobal();
    public static String dir = "src/main/resources/jena/";
    public static String model_file = "scenicnode.owl";

    public static OntModel model;
    public static String scnode;
    public static Configuration cfg;

    public static void main(String[] args) throws IOException {
        // Initialization
        System.out.println("------ Jena Initialization -------");
        {   // Jena: read model file
            model = ModelFactory.createOntologyModel();
            model.read(dir + model_file);
            //Reading from .owl into a newly created model.
            model.write(System.out);
            scnode = model.getNsPrefixURI("scnode");
        }
        System.out.println("------ FreeMarker Initialization -------");
        {   //FreeMakder: settings
            cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(dir));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
        }
        System.out.println("------ Initialization completed. -------");

        ExtendedIterator<OntClass> classes = model.listClasses();
        List<Clazz> clazzs = new ArrayList<>();
        classes.forEachRemaining((OntClass clazz) -> {
            Clazz c = new Clazz();
            String[] class_name = clazz.toString().split("#");
            if (class_name.length > 1) {
                _logger.log(Level.INFO, clazz.toString());
                c.setName(class_name[1]);
                clazzs.add(c);
                model.listStatements(clazz, null, (String) null).forEachRemaining(System.out::println);
//                    model.listStatements(null, null, clazz).forEachRemaining(System.out::println);
//                    model.listStatements(null, null, clazz).forEachRemaining((Statement t) -> {
//                         System.out.println(t);
//                         if (t.getSubject().toString().split("#").length == 1) {
//                              model.listStatements(null, null, t.getSubject());
//                              model.listStatements(t.getSubject(), null, (String) null);
//                         }
//                    });
            }
        });
        System.out.println("------ getNsPrefixMap -------");
        model.getNsPrefixMap().entrySet().forEach(System.out::println);
        System.out.println("------ listAllOntProperties -------");
        model.listAllOntProperties().forEachRemaining(System.out::println);
        System.out.println("------ createProperty -------");
        OntProperty prop = model.createOntProperty(scnode + "hasComponent");
        System.out.println(prop);
        System.out.println("------ listSubjects-------");
        model.listSubjects().forEachRemaining(System.out::println);
        System.out.println("------ listObjects-------");
        model.listObjects().forEachRemaining(System.out::println);
//          System.out.println("------ listSubjectsWithProperty -------");
//          model.listSubjectsWithProperty(prop).forEachRemaining(System.out::println);
//          System.out.println("------ listObjectsOfProperty -------");
//          model.listObjectsOfProperty(prop).forEachRemaining(System.out::println);

//          model.listObjectsOfProperty(model.createProperty(scnode + "hasComponent")).forEachRemaining(System.out::println);
//          classes.forEachRemaining((clazz) -> {
//               try {
//                    Template classTemp = null;
//                    classTemp = cfg.getTemplate("class.template");
//                    Map<String, Object> root = new HashMap<>();
//
//                    Clazz c = new Clazz();
//                    String[] class_name = clazz.toString().split("#");
//                    if (class_name.length > 1) {
//                         c.setName(class_name[1]);
//                         List<Property> properties = new ArrayList<>();
//                         properties.add(new Property("String", "someStr"));
//                         properties.add(new Property("String", "someStr2"));
//                         properties.add(new Property("String", "someStr3"));
//                         c.setProperties(properties);
//                         root.put("class", c);
//                         StringWriter out = new StringWriter();
//                         classTemp.process(root, out);
//                         System.out.println(out);
//                    }
//               } catch (Exception ex) {
//                    _logger.log(Level.SEVERE, null, ex);
//               }
//          });
    }

//     public static void amain(String[] args) throws IOException, TemplateException {
//
//          Map<String, Object> root = new HashMap<>();
//
//          IBot iBot = new IBot();
//          List<ScenicNode> scenic_nodes = new ArrayList<>();
//
//          ScenicNode node = new ScenicNode();
//          node.setNode_type("Node_Terminal");
//          Scenario scenario = new Scenario("Hello World!");
//          Resource resource1 = new Resource(), resource2 = new Resource();
//          resource1.getResource().put("img", node.getId() + "_001.jpg");
//          scenario.getResources().add(resource1);
//          node.setScenario(scenario);
//          scenic_nodes.add(node);
//
//          for (int i = 0; i < 10; i++) {
//               String next_id = node.getId();
//
//               node = new ScenicNode();
//               node.setNode_type("Node_Successive");
//               node.setLinked_node(next_id);
//               scenario = new Scenario("Hello World " + i + " times.");
//               resource1.getResource().put("img", node.getId() + "_001.jpg");
//               resource1.getResource().put("audio", node.getId() + "_001.mp3");
//               resource2.getResource().put("img", node.getId() + "_002.jpg");
//               resource2.getResource().put("audio", node.getId() + "_002.mp3");
//               scenario.getResources().add(resource1);
//               scenario.getResources().add(resource2);
//               node.setScenario(scenario);
//               scenic_nodes.add(node);
//          }
//
//          iBot.setScenic_nodes(scenic_nodes);
//          root.put("bot", iBot);
//
//          StringWriter out = new StringWriter();
////          Writer out = new OutputStreamWriter(System.out);
//          scenicnode.process(root, out);
//          System.out.println(out);
//     }
}
