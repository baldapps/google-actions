/*
 * Copyright 2017-2018 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * Google Actions is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Google Actions is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Google Actions.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.dialogflow.v2.model;

import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("lifespanCount")
	@Expose
	private Integer lifespanCount;
	@SerializedName("parameters")
	@Expose
	private HashMap<String, JsonElement> parameters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLifespanCount() {
		return lifespanCount;
	}

	public void setLifespanCount(Integer lifespanCount) {
		this.lifespanCount = lifespanCount;
	}

	public HashMap<String, JsonElement> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, JsonElement> parameters) {
		this.parameters = parameters;
	}

}
