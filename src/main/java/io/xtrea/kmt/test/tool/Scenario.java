/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.xtrea.kmt.test.tool;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Scenario {

     public Scenario(String article) {
          this.article = article;
     }

     private String article;

     private List<Map<String, String>> resources;

     /**
      * Get the value of resources
      *
      * @return the value of resources
      */
     public List<Map<String, String>> getResources() {
          return resources;
     }

     /**
      * Set the value of resources
      *
      * @param resources new value of resources
      */
     public void setResources(List<Map<String, String>> resources) {
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
