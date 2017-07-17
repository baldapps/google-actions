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

package com.balda.keys;

import java.security.GeneralSecurityException;
import java.security.Key;

import com.balda.tokens.TokenPayload;
import com.google.gson.Gson;

public class TokenGenerator {

	public static Key generateKey() throws GeneralSecurityException {
		// TODO implement your logic here
		return null;
	}

	/**
	 * Generate a token
	 * 
	 * @param json
	 *            Gson instance
	 * @param user
	 *            The token payload to be encrypted
	 * @param key
	 *            The key to use
	 * @return Encrypted token
	 * @throws TokenException
	 */
	public static String generate(Gson json, TokenPayload user, Key key) throws TokenException {
		// TODO implement your logic here
		return null;
	}

	/**
	 * Return a payload using a signed token
	 * 
	 * @param json
	 *            Gson instance
	 * @param token
	 *            The token received
	 * @param key
	 *            The key
	 * @return The payload
	 * @throws TokenException
	 */
	public static TokenPayload revert(Gson json, String token, Key key) throws TokenException {
		// TODO implement your logic here
		return null;
	}
}
