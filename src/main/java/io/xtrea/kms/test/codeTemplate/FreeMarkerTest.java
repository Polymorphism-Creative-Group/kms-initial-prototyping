/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.xtrea.kms.test.codeTemplate;

import io.xtrea.kms.test.model.Resource;
import io.xtrea.kms.test.model.IBot;
import io.xtrea.kms.test.model.ScenicNode;
import io.xtrea.kms.test.model.Scenario;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class FreeMarkerTest {

     public static void main(String[] args) throws IOException, TemplateException {
          /**
           * Create your Configuration instance, and specify if up to what
           * FreeMarker version (here 2.3.27) do you want to apply the fixes
           * that are not 100% backward-compatible. See the Configuration
           * JavaDoc for details.
           */
          Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
          /**
           * Specify the source where the template files come from. Here I set a
           * plain directory for it, but non-file-system sources are possible
           * too:
           */
          cfg.setDirectoryForTemplateLoading(new File("src/main/resources/freemarker_templates/"));
          /**
           * Set the preferred charset template files are stored in. UTF-8 is a
           * good choice in most applications:
           */
          cfg.setDefaultEncoding("UTF-8");
          /**
           * Sets how errors will appear. During web page *development*
           * TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
           */
          cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
          /**
           * Don't log exceptions inside FreeMarker that it will thrown at you
           * anyway:
           */
          cfg.setLogTemplateExceptions(false);
          /**
           * Wrap unchecked exceptions thrown during template processing into
           * TemplateException-s.
           */
          cfg.setWrapUncheckedExceptions(true);

          Template scenicnode = cfg.getTemplate("scenicnode.xml");

          Map<String, Object> root = new HashMap<>();

          IBot iBot = new IBot();
          List<ScenicNode> scenic_nodes = new ArrayList<>();

          ScenicNode node = new ScenicNode();
          node.setNode_type("Node_Terminal");
          Scenario scenario = new Scenario("Hello World!");
          Resource resource1 = new Resource(), resource2 = new Resource();
          resource1.getResource().put("img", node.getId() + "_001.jpg");
          scenario.getResources().add(resource1);
          node.setScenario(scenario);
          scenic_nodes.add(node);

          for (int i = 0; i < 10; i++) {
               String next_id = node.getId();

               node = new ScenicNode();
               node.setNode_type("Node_Successive");
               node.setLinked_node(next_id);
               scenario = new Scenario("Hello World " + i + " times.");
               resource1.getResource().put("img", node.getId() + "_001.jpg");
               resource1.getResource().put("audio", node.getId() + "_001.mp3");
               resource2.getResource().put("img", node.getId() + "_002.jpg");
               resource2.getResource().put("audio", node.getId() + "_002.mp3");
               scenario.getResources().add(resource1);
               scenario.getResources().add(resource2);
               node.setScenario(scenario);
               scenic_nodes.add(node);
          }
          
          iBot.setScenic_nodes(scenic_nodes);
          root.put("bot", iBot);

          StringWriter out = new StringWriter();
//          Writer out = new OutputStreamWriter(System.out);
          scenicnode.process(root, out);
          System.out.println(out);
     }
}
