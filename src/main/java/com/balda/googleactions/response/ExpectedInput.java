/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * AirTask Desktop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AirTask Desktop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AirTask Desktop.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.googleactions.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExpectedInput {

	@SerializedName("inputPrompt")
	@Expose
	private InputPrompt inputPrompt;
	@SerializedName("possibleIntents")
	@Expose
	private List<ExpectedIntent> possibleIntents = null;
	@SerializedName("speechBiasingHints")
	@Expose
	private List<String> speechBiasingHints;

	public List<String> getSpeechBiasingHints() {
		return speechBiasingHints;
	}

	public void setSpeechBiasingHints(List<String> speechBiasingHints) {
		this.speechBiasingHints = speechBiasingHints;
	}

	public InputPrompt getInputPrompt() {
		return inputPrompt;
	}

	public void setInputPrompt(InputPrompt inputPrompt) {
		this.inputPrompt = inputPrompt;
	}

	public List<ExpectedIntent> getPossibleIntents() {
		return possibleIntents;
	}

	public void setPossibleIntents(List<ExpectedIntent> possibleIntents) {
		this.possibleIntents = possibleIntents;
	}

}
