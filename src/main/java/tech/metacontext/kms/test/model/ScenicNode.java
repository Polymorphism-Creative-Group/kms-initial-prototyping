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
package tech.metacontext.kms.test.model;

import tech.metacontext.kms.test.jena.model.XtreaOperableItem;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class ScenicNode extends XtreaOperableItem {

     private String node_type;

     private String linked_node;

     private Scenario scenario;

     /**
      * Get the value of linked_node
      *
      * @return the value of linked_node
      */
     public String getLinked_node() {
          return linked_node;
     }

     /**
      * Set the value of linked_node
      *
      * @param linked_node new value of linked_node
      */
     public void setLinked_node(String linked_node) {
          this.linked_node = linked_node;
     }

     /**
      * Get the value of node_type
      *
      * @return the value of node_type
      */
     public String getNode_type() {
          return node_type;
     }

     /**
      * Set the value of node_type
      *
      * @param node_type new value of node_type
      */
     public void setNode_type(String node_type) {
          this.node_type = node_type;
     }

     /**
      * Get the value of scenario
      *
      * @return the value of scenario
      */
     public Scenario getScenario() {
          return scenario;
     }

     /**
      * Set the value of scenario
      *
      * @param scenario new value of scenario
      */
     public void setScenario(Scenario scenario) {
          this.scenario = scenario;
     }

}
