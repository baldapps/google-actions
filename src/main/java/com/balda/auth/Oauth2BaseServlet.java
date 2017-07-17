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

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Base class for Oauth2 management
 */
public abstract class Oauth2BaseServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(Oauth2BaseServlet.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 4586891345686710160L;
	public static final String RESPONSE_CONTENT_TYPE = "application/json";
	public static final String RESPONSE_CHARACTER_ENCODING = "utf-8";
	protected final Gson gson;

	public Oauth2BaseServlet() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Oauth2Error.class, new Oauth2Error.ErrorCodeSerializer());
		gson = gsonBuilder.create();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Only HTTPS traffic is allowed */
		if (!req.isSecure()) {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN);
			log.warning("Received request http from: " + req.getRemoteAddr() + ":" + req.getRemoteHost());
			return;
		}
		request(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Only HTTPS traffic is allowed */
		if (!req.isSecure()) {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN);
			log.warning("Received request http from: " + req.getRemoteAddr() + ":" + req.getRemoteHost());
			return;
		}
		request(req, resp);
	}

	protected abstract void request(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

	protected void sendError(HttpServletResponse resp, Oauth2Error code) throws IOException {
		resp.sendError(HttpServletResponse.SC_BAD_REQUEST, gson.toJson(code));
	}
}
