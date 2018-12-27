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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdfxml.xmlinput.JenaReader;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.rulesys.RDFSRuleReasonerFactory;
import org.apache.jena.vocabulary.ReasonerVocabulary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class JenaTest {

     Model model = ModelFactory.createDefaultModel();
     String rdfs = model.getNsPrefixURI("rdfs");
     String ibot = model.getNsPrefixURI("ibot");

     public JenaTest() {
     }

     @BeforeClass
     public static void setUpClass() {
     }

     @AfterClass
     public static void tearDownClass() {
     }

     @Before
     public void setUp() throws IOException {
          //Reading from .owl into a newly created model.
          InputStream ins = Files.newInputStream(new File("src/main/resources/scenicnode.owl").toPath());
          new JenaReader().read(model, ins, null);
          model.write(System.out);
          System.out.println("------ Initialization completed. -------");
     }

     @After
     public void tearDown() {
     }

     @Test
     public void listResource() {

          model.listResourcesWithProperty(model
                  .createProperty(rdfs, "subClassOf"))
                  .forEachRemaining(System.out::println);
     }

     @Test
     public void inferenceModel() {
          Resource config = ModelFactory.createDefaultModel()
                  .createResource()
                  .addProperty(ReasonerVocabulary.PROPsetRDFSLevel, "simple");
          Reasoner reasoner = RDFSRuleReasonerFactory.theInstance().create(config);
          InfModel inf = ModelFactory.createInfModel(reasoner, model);
          inf.listStatements().forEachRemaining(System.out::println);
//          write(System.out);
          Selector s = new SimpleSelector(
                  //                  model.createResource(ibot + "IBot"),
                  model.createProperty(ibot, "hasComponent"),
                  //                  null,
                  null,
                  //                  model.createProperty(rdfs, "subClassOf"),
                  //                  model.createResource(ibot + "IBot")
                  //                  model.createResource(ibot + "ScenicScript")
                  (Object) null
          );
          inf.query(s);
     }

     @Test
     public void simpleSelector() {
          //Use of SimpleSelector
          Selector s = new SimpleSelector(
                  //                  model.createResource(ibot + "IBot"),
                  null,
                  null,
                  //                  model.createProperty(rdfs, "subClassOf"),
                  //                  model.createResource(ibot + "IBot")
                  //                  model.createProperty(ibot, "hasComponent")
                  model.createResource(ibot + "ScenicScript")
          //                  (Object) null
          );
          model.query(s).listStatements().forEachRemaining((Statement stmt) -> {
               System.out.println(stmt);
//               System.out.printf("%s -> %s\n",stmt.getResource(), stmt.getObject());
          });
//                  ;write(System.out);
     }

     @Test
     public void printNsPrefixMap() {
          model.getNsPrefixMap().entrySet().forEach(System.out::println);
     }
}
