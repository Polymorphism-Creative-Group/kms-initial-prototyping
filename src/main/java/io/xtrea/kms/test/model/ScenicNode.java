/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.xtrea.kms.test.model;

import io.xtrea.kms.test.jena.model.XtreaOperableItem;

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
