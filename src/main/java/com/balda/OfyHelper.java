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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OfyHelper implements ServletContextListener {

	public static void register() {
		// TODO your datastore logic here with objectify (if any)
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		register();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}
