/*
 * $Id: ExampleSupport.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cn.com.oceansoft.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action 基类，设置公共属性供子类使用
 *
 * @author 胡荆陵
 */
public class BaseAction extends ActionSupport {

    protected String id; //对象的主键, 查看/修改/删除 时使用

    //getter & setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
