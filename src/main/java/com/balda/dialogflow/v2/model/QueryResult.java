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
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryResult {

	@SerializedName("queryText")
	@Expose
	private String queryText;
	@SerializedName("action")
	@Expose
	private String action;
	@SerializedName("parameters")
	@Expose
	private HashMap<String, JsonElement> parameters;
	@SerializedName("allRequiredParamsPresent")
	@Expose
	private Boolean allRequiredParamsPresent;
	@SerializedName("outputContexts")
	@Expose
	private List<Context> outputContexts = null;
	@SerializedName("intent")
	@Expose
	private Intent intent;
	@SerializedName("intentDetectionConfidence")
	@Expose
	private Integer intentDetectionConfidence;
	@SerializedName("languageCode")
	@Expose
	private String languageCode;

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public HashMap<String, JsonElement> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, JsonElement> parameters) {
		this.parameters = parameters;
	}

	public Boolean getAllRequiredParamsPresent() {
		return allRequiredParamsPresent;
	}

	public void setAllRequiredParamsPresent(Boolean allRequiredParamsPresent) {
		this.allRequiredParamsPresent = allRequiredParamsPresent;
	}

	public List<Context> getOutputContexts() {
		return outputContexts;
	}

	public void setOutputContexts(List<Context> outputContexts) {
		this.outputContexts = outputContexts;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public Integer getIntentDetectionConfidence() {
		return intentDetectionConfidence;
	}

	public void setIntentDetectionConfidence(Integer intentDetectionConfidence) {
		this.intentDetectionConfidence = intentDetectionConfidence;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

}
