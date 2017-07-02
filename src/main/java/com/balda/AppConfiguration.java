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

package com.balda;

public class AppConfiguration {

	/**
	 * Our credentials for API.AI no one can access to our end point with
	 * authorization
	 */
	public static final String USERNAME = "API AI USERNAME HERE";
	public static final String PASSWORD = "API AI PASSWORD HERE";

	/**
	 * Client id created via Google console, Oauth2 id web application
	 */
	public static final String CLIENT_ID = "REPLACE YOUR ID HERE";

	/**
	 * Client secret created via Google console, Oauth2 id web application
	 */
	public static final String CLIENT_SECRET = "REPLACE YOUR SECRET HERE";

	/**
	 * Redirect URI allowed. This uri must be whitelisted in your Google cloud
	 * console
	 */
	public static final String REDIRECT_URI = "https://oauth-redirect.googleusercontent.com/r/<REPLACE YOUR PROJECT ID HERE>";
}
