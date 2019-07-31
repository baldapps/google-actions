/*
 * Copyright 2019 Marco Stornelli <playappassistance@gmail.com>
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

package com.balda.googleactions.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capability {

	@SerializedName("name")
	@Expose
	private String name;

	public static final String CAPABILITY_SCREEN = "actions.capability.SCREEN_OUTPUT";
	public static final String CAPABILITY_AUDIO = "actions.capability.AUDIO_OUTPUT";
	public static final String CAPABILITY_MEDIA = "actions.capability.MEDIA_RESPONSE_AUDIO";
	public static final String CAPABILITY_WEB = "actions.capability.WEB_BROWSER";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
