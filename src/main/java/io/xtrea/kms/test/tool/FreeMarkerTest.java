/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.xtrea.kms.test.tool;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
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

          ScenicNode node = new ScenicNode();
          node.setId(UUID.randomUUID().toString());
          node.setNode_type("Node_Successive");
          node.setLinked_node("Node_Successive");
          Scenario scenario = new Scenario("Hello World!");
          Map<String, String> resource1 = new HashMap<>(), resource2 = new HashMap<>();
          scenario.getResources().add(resource1);
          scenario.getResources().add(resource2);
          node.setScenario(scenario);
          System.out.println(node.getScenario().getArticle());

          root.put("bot_id", UUID.randomUUID());
          root.put("node", node);

          StringWriter out = new StringWriter();
//          Writer out = new OutputStreamWriter(System.out);
          scenicnode.process(root, out);
          System.out.println(out);
     }
}
