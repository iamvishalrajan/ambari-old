/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.view.pig.services;

import org.apache.ambari.view.ViewContext;
import org.apache.ambari.view.ViewResourceHandler;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

/**
 * Help service
 */
public class HelpService extends BaseService {
  private ViewContext context;
  private ViewResourceHandler handler;

  /**
   * Constructor
   * @param context View Context instance
   * @param handler View Resource Handler instance
   */
  public HelpService(ViewContext context, ViewResourceHandler handler) {
    super();
    this.context = context;
    this.handler = handler;
  }

  /**
   * View configuration
   * @return configuration of HDFS
   */
  @GET
  @Path("/config")
  @Produces(MediaType.APPLICATION_JSON)
  public Response config(){
    JSONObject object = new JSONObject();
    String fs = context.getProperties().get("dataworker.defaultFs");
    object.put("dataworker.defaultFs", fs);
    return Response.ok(object).build();
  }

  /**
   * Version
   * @return version
   */
  @GET
  @Path("/version")
  @Produces(MediaType.TEXT_PLAIN)
  public Response version(){
    return Response.ok("0.0.1-SNAPSHOT").build();
  }
}
