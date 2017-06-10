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

package com.balda.tokens;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenPayload {
	@SerializedName("user_id")
	@Expose
	private String userId;
	@SerializedName("type")
	@Expose
	private TokenType type;
	@SerializedName("expiration_time")
	@Expose
	private long expirationTime;

	public TokenPayload() {
		userId = "";
		expirationTime = -1;
		type = TokenType.AUTH_TOKEN;
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		if (userId != null)
			this.userId = userId;
	}
}
