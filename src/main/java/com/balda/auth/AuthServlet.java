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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balda.AppConfiguration;
import com.balda.keys.TokenException;

/**
 * Base class to manage the auth request
 *
 */
public abstract class AuthServlet extends Oauth2BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4713964796466480055L;

	private static final Logger log = Logger.getLogger(AuthServlet.class.getName());

	@Override
	public void request(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Oauth2Request oauth2;
		try {
			oauth2 = new Oauth2Request(req);
		} catch (IllegalArgumentException e) {
			sendError(resp, Oauth2Error.INVALID_REQUEST);
			log.warning("Not valid request: " + req.toString());
			return;
		}

		if (AppConfiguration.CLIENT_ID.equals(oauth2.getClientId())
				&& AppConfiguration.REDIRECT_URI.equals(oauth2.getRedirectUri())) {
			try {
				if (oauth2.isImplicit())
					performImplictFlow(oauth2, req, resp);
				else
					performAuthFlow(oauth2, req, resp);
			} catch (TokenException e) {
				log.log(Level.WARNING, "token exception", e);
				sendError(resp, Oauth2Error.INVALID_GRANT);
				return;
			}
		} else {
			sendError(resp, Oauth2Error.UNAUTHORIZED_CLIENT);
			log.warning("Not valid request: " + req.toString());
		}
	}

	protected abstract void performImplictFlow(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException;

	protected abstract void performAuthFlow(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException;
}
