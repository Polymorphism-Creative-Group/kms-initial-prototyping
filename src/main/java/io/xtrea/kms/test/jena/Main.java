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

import static io.xtrea.kms.test.jena.Setting.uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import io.xtrea.kms.test.jena.model.ScenicNode;

/**
 * Examples from https://jena.apache.org/tutorials/rdf_api.html.
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

     public static void main(String[] args) {
          // Initialization
          Model model = ModelFactory.createDefaultModel();
          model.setNsPrefix("iBot", uri);

          /*
        * IBot Vocabularies.
           */
          Property hasComponent = model.createProperty(uri + "hasComponent");
          Property isComponentOf = model.createProperty(uri + "idComponentOf");
          Property isMadeOf = model.createProperty(uri + "isMadeOf");
          Property hasType = model.createProperty(uri + "hasType");
          Property isTypeOf = model.createProperty(uri + "isTypeOf");

          /**
           * IBot Construction.
           */
          Resource IBot = model.createResource(uri + "IBot");

          // ScenicScript
          Resource ScenicScript = model.createResource(uri + "ScenicScript");
          IBot.addProperty(hasComponent, ScenicScript);

          // ScenicNode
          Resource ScenicNode = model.createResource(uri + "ScenicNode");
          ScenicScript.addProperty(isMadeOf, ScenicNode);
          // ScenicNode - Scenario
          Resource Scenario = model.createResource(uri + "Scenario");
          // ScenicNode - GameMechanism
          Resource GameMechanism = model.createResource(uri + "GameMachanism");

          ScenicNode.addProperty(hasComponent, Scenario)
                  .addProperty(hasComponent, GameMechanism);

          /*
         * Build NodeType
           */
          List<Resource> NodeType = new ArrayList<>();
          Arrays.asList(new String[]{
               "Node_Successive",
               "Node_SelectReaction",
               "Node_Terminal",
               "NodeLinker"})
                  .forEach((node_name) -> {
                       NodeType.add(model.createResource(uri + node_name));
                  });
          NodeType.forEach((type) -> {
               ScenicNode.addProperty(hasType, type);
          });
          RDFDatatype RDFNodeType = model.createTypedLiteral(
                  new ScenicNode()).getDatatype();

          System.out.println(RDFNodeType.toString());
          model.getResource(uri + "NodeLinker")
                  .addProperty(hasType, "NodeLinker_Quit");

          model.write(System.out);
          model.getResource(uri + "ScenicNode").listProperties()
                  .forEachRemaining(System.out::println);
     }
}
