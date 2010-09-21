package com.t3ch.unixepochconverter;

/****************************************************************
 * Copyright 2010 Joe Nicosia <joe@t3ch.com>  
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ****************************************************************/

import java.text.ParseException;
import java.util.Date;
//import java.util.TimeZone;

import android.util.Log;

public class CurrentTime {
	private static final String TAG = "UnixEpochConverter";

	public String displayCurrentTime() {

		// Fetch current date/time
		Date date = new Date();
		Integer day = (Integer) date.getDate();
		Integer month = (Integer) date.getMonth();
		Integer year = (Integer) date.getYear();
		year = year + 1900;
		Integer hour = (Integer) date.getHours();
		Integer minute = (Integer) date.getMinutes();
		Integer second = (Integer) date.getSeconds();
		
		// normalize month variable
		month = month+1;
		String monthString;
		if (month < 10) {
			monthString = month.toString();
			monthString = "0" + month;
		} else {
			monthString = month.toString();
		}
		
		// debug crap
		Log.d(TAG, "day: " + day);
		Log.d(TAG, "month: " + monthString);
		Log.d(TAG, "year: " + year);
		Log.d(TAG, "hour: " + hour);
		Log.d(TAG, "minute: " + minute);
		Log.d(TAG, "second: " + second);
		
		Date epoch = null;
		// convert current date/time into unix epoch timestamp
		try {
			epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(monthString + "/" + day + "/" + year + " " + hour + ":" + minute + ":" + second);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		Long convertedTime = (Long) epoch.getTime();
		convertedTime = convertedTime/1000;
		String convertedString = (String) convertedTime.toString();
		Log.d(TAG, convertedString);
		return convertedString;
	}
}
