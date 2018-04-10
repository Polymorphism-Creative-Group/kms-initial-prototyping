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
package io.xtrea.kms.test.generated.ontology;

import java.io.File;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

     public static void main(String[] args) throws OWLOntologyCreationException {
          //Load ontology file
          File oFile = new File("src/main/resources/scenicnode.owl");
          OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
          OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(oFile);
          //get prefix
          DefaultPrefixManager prefixManager = new DefaultPrefixManager();
          OWLDocumentFormat format
                  = ontology.getOWLOntologyManager().getOntologyFormat(ontology);
          if (format.isPrefixOWLOntologyFormat()) {
               prefixManager.copyPrefixesFrom(format.asPrefixOWLOntologyFormat().getPrefixName2PrefixMap());
          }
          prefixManager.getPrefixNames().forEach(System.out::println);
          //create IlyaBotFactory
          IlyaBotFactory ibot = new IlyaBotFactory(ontology);
          IlyaBot ilyaBot = ibot.createIlyaBot("Hello");
          Article a = ibot.createArticle("Hello World!");
          a.getOwlOntology().getAxioms().forEach(System.out::println);
          System.out.println(a.getOwlIndividual());
     }

}
