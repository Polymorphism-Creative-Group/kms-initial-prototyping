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
package io.xtrea.plod.test;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

/**
 * Examples from https://jena.apache.org/tutorials/rdf_api.html.
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

     public static void main(String[] args) {
          // some definitions

          String personURI = "http://somewhere/JohnSmith";
          String givenName = "John";
          String familyName = "Smith";
          String fullName = givenName + " " + familyName;

          // create an empty Model
          Model model = ModelFactory.createDefaultModel();

          // create the resource
          //   and add the properties cascading style
          Resource johnSmith
                  = model.createResource(personURI)
                          .addProperty(VCARD.FN, fullName)
                          .addProperty(VCARD.N,
                                  model.createResource()
                                          .addProperty(VCARD.Given, givenName)
                                          .addProperty(VCARD.Family, familyName));

          model.write(System.out);

     }
}
