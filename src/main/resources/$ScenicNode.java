
import io.xtrea.kms.test.jena.model.XtreaOperableItem;

/*
 * Copyright 2018 Jonathan Chang, Chun-yien <ccy@xtrea.io>.
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
/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@xtrea.io>
 */
public abstract class $ScenicNode extends XtreaOperableItem {

     private $Scenario scenario;

     public $ScenicNode() {
     }

     public $Scenario get$Scenario() {
          return scenario;
     }

     public void set$Scenario($Scenario scenario) {
          this.scenario = scenario;
     }

//     public abstract $ScenicNode play(JSONObject params);
//     public $ScenicNode play() {
//          return play(null);
//     }
}

class $Scenario {
}
