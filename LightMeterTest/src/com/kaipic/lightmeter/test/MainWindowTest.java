/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kaipic.lightmeter.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import com.kaipic.lightmeter.MainWindow;
import com.kaipic.lightmeter.R;

/**
 * Make sure that the main launcher activity opens up properly, which will be
 * verified by {@link ActivityTestCase#testActivityTestCaseSetUpProperly}.
 */
public class MainWindowTest extends
		ActivityInstrumentationTestCase2<MainWindow> {
	private Instrumentation mInstrumentation;
	private MainWindow mActivity;
	private Button mButton;
	private TextView mSensorReadView;

	public MainWindowTest() {
		super("com.kaipic.lightmeter", MainWindow.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mInstrumentation = getInstrumentation();
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
		mButton = (Button) mActivity.findViewById(R.id.read_button);
		mSensorReadView = (TextView) mActivity.findViewById(R.id.sensor_read_text_view);
		
	}

	public void testCreateActivity() {
		assertNotNull(mActivity);
		assertNotNull(mButton);
		assertNotNull(mSensorReadView);
		assertEquals("", mSensorReadView.getText());
			
	}


	public void testClickButton() {
		mActivity.runOnUiThread(new Runnable() {
			public void run() {
				mButton.requestFocus();
			}
		});
		mInstrumentation.waitForIdleSync();
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		mInstrumentation.waitForIdleSync();
		
		assertEquals("1", mSensorReadView.getText());
		
	}
}
