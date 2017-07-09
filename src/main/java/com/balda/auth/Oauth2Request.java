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

package com.balda.auth;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.repackaged.org.apache.http.util.TextUtils;

public class Oauth2Request {
	private String clientId;
	private String redirectUri;
	private String state;
	private String grantType;
	private String responseType;
	private String clientSecret;
	private String code;
	private String refreshToken;
	public static final String GRANT_AUTH = "authorization_code";
	public static final String GRANT_REFRESH = "refresh_token";
	public static final String RESPONSE_TYPE_TOKEN = "token";
	public static final String RESPONSE_TYPE_CODE = "code";

	public Oauth2Request(HttpServletRequest req) {
		clientId = req.getParameter("client_id");
		redirectUri = req.getParameter("redirect_uri");
		state = req.getParameter("state");
		grantType = req.getParameter("grant_type");
		responseType = req.getParameter("response_type");
		clientSecret = req.getParameter("client_secret");
		code = req.getParameter("code");
		refreshToken = req.getParameter("refresh_token");
		if (TextUtils.isEmpty(clientId))
			throw new IllegalArgumentException("malformed request");
		if (GRANT_AUTH.equals(grantType)) {
			// Access token request
			if (TextUtils.isEmpty(clientSecret) || TextUtils.isEmpty(code))
				throw new IllegalArgumentException("malformed request");
		} else if (GRANT_REFRESH.equals(grantType)) {
			// Refresh token request
			if (TextUtils.isEmpty(clientSecret) || TextUtils.isEmpty(refreshToken))
				throw new IllegalArgumentException("malformed request");
		} else if (RESPONSE_TYPE_CODE.equals(responseType)) {
			// Auth code request
			if (TextUtils.isEmpty(redirectUri))
				throw new IllegalArgumentException("malformed request");
		} else if (RESPONSE_TYPE_TOKEN.equals(responseType)) {
			// Implicit flow request
			if (TextUtils.isEmpty(redirectUri))
				throw new IllegalArgumentException("malformed request");
		} else
			throw new IllegalArgumentException("malformed request");
	}

	public String getClientId() {
		return clientId;
	}

	public String getResponseType() {
		return responseType;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getCode() {
		return code;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getState() {
		return state;
	}

	public boolean isImplicit() {
		return RESPONSE_TYPE_TOKEN.equals(responseType);
	}

	public boolean isCodeRequest() {
		return GRANT_AUTH.equals(grantType);
	}

	public String getResponseUri(String token) {
		String stateValue = "";
		if (!TextUtils.isEmpty(state))
			stateValue = "&state=" + state;
		if (RESPONSE_TYPE_TOKEN.equals(responseType))
			return redirectUri + "#access_token=" + token + "&token_type=bearer" + stateValue;
		else
			return redirectUri + "?code=" + token + stateValue;
	}
}
