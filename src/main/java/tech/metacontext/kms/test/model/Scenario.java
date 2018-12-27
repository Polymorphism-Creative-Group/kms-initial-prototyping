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
