/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
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

package com.balda.googleactions.response;

import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExpectedIntent {

	@SerializedName("intent")
	@Expose
	private String intent;

	@SerializedName("inputValueData")
	@Expose
	private Map<String, JsonElement> inputValueData;

	public ExpectedIntent() {

	}

	public ExpectedIntent(String i) {
		intent = i;
	}

	public Map<String, JsonElement> getInputValueSpec() {
		return inputValueData;
	}

	public void setInputValueSpec(Map<String, JsonElement> inputValueSpec) {
		this.inputValueData = inputValueSpec;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

}
