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
package io.xtrea.kms.test.codeTemplate;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class VelocityTest {

    static String file = "src/main/resources/velocity_scenicnode.xml";

    public static void main(String[] args)
            throws Exception {
        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template scenicNode = ve.getTemplate(file);
        /*  create a context and add data */
        VelocityContext cxtScenicNode = new VelocityContext();

        cxtScenicNode.put("bot_id", UUID.randomUUID());

        List scenic_nodes = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Map node = new HashMap();
            node.put("id", UUID.randomUUID());
            if (i % 2 == 0) {
                node.put("node_type", "Node_Successive");
                node.put("linked_node", UUID.randomUUID());
                List resources = new ArrayList();
                for (int j = i * 3; j < i * 3 + 3; j++) {
                    Map resourceMap = new HashMap();
                    resourceMap.put("key", "img");
                    resourceMap.put("value", "node00" + j + ".jpg");
                    resources.add(resourceMap);
                }
                node.put("resources", resources);
            } else {
                node.put("node_type", "Nodelinker_Random");
            }
            node.put("article", "您已進入了夢土" + i);
            scenic_nodes.add(node);
        }
        cxtScenicNode.put("scenic_nodes", scenic_nodes);
        StringWriter writer = new StringWriter();
        /* now render the template into a StringWriter */
        scenicNode.merge(cxtScenicNode, writer);
        /* show the World */
        System.out.println("---------------\n" + writer.toString());
    }
}
