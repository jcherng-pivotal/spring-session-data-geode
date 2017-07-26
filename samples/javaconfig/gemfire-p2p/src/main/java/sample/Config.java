/*
 * Copyright 2014-2016 the original author or authors.
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

package sample;

import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.data.gemfire.config.annotation.PeerCacheApplication;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

// tag::class[]
@PeerCacheApplication(name = "SpringSessionSampleJavaConfigGemFireP2p", logLevel = "warning") // <1>
@EnableGemFireHttpSession // <2>
@EnableManager(start = true) // <3>
public class Config {

}
// end::class[]
