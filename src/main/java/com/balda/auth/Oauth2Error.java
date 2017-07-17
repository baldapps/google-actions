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

package com.balda.auth;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public enum Oauth2Error {
	//@formatter:off
	INVALID_REQUEST("invalid_request","The request was malformed, or contains unsupported parameters"),
	INVALID_CLIENT("invalid_client","The client authentication failed."),
	INVALID_GRANT("invalid_grant", "The provided authorization is invalid."),
	UNAUTHORIZED_CLIENT("unauthorized_client","The client application is not allowed to use this grant_type."),
	UNSUPPORTED_GRANT_TYPES("unsupported_grant_type", "A grant_type other than “password” was used in the request."),
	INVALID_SCOPE("invalid_scope", "The scope was not correctly set");
	//@formatter:on

	private String error;
	private String description;

	private Oauth2Error(String e, String d) {
		error = e;
		description = d;
	}

	public String getError() {
		return error;
	}

	public String getDesc() {
		return description;
	}

	public static class ErrorCodeSerializer implements JsonSerializer<Oauth2Error> {
		@Override
		public JsonElement serialize(Oauth2Error arg0, Type arg1, JsonSerializationContext arg2) {
			final JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("error", arg0.getError());
			jsonObject.addProperty("error_desc", arg0.getDesc());
			return jsonObject;
		}
	}
}
