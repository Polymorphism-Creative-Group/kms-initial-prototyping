/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.xtrea.kms.test.model;

import io.xtrea.kms.test.jena.model.XtreaOperableItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Scenario extends XtreaOperableItem {

     private String article;

     private List<Resource> resources;

     public Scenario(String article) {
          this.article = article;
          this.resources = new ArrayList<>();
     }

     /**
      * Get the value of resources
      *
      * @return the value of resources
      */
     public List<Resource> getResources() {
          return resources;
     }

     /**
      * Set the value of resources
      *
      * @param resources new value of resources
      */
     public void setResources(List<Resource> resources) {
          this.resources = resources;
     }

     /**
      * Get the value of article
      *
      * @return the value of article
      */
     public String getArticle() {
          return article;
     }

     /**
      * Set the value of article
      *
      * @param article new value of article
      */
     public void setArticle(String article) {
          this.article = article;
     }

}
