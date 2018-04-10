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
package io.xtrea.kms.test.model;

import io.xtrea.kms.test.jena.model.XtreaOperableItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class IBot extends XtreaOperableItem {

     private List<ScenicNode> scenic_nodes;

     public IBot() {
          this.scenic_nodes = new ArrayList<>();
     }

     public List<ScenicNode> getScenic_nodes() {
          return scenic_nodes;
     }

     public void setScenic_nodes(List<ScenicNode> scenic_nodes) {
          this.scenic_nodes = scenic_nodes;
     }
}
