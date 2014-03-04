/*
 * Copyright (C) 2013 BeyondAR
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
package com.beyondar.example;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.module.radar.RadarView;
import com.beyondar.android.module.radar.RadarWorldModule;
import com.beyondar.android.world.World;

public class SimpleCameraWithRadarActivity extends FragmentActivity {

	private BeyondarFragmentSupport mBeyondarFragment;
	private RadarView mRadarView;
	private RadarWorldModule mRadarModule;
	private World mWorld;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Hide the window title.
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.simple_camera_with_radar);

		mBeyondarFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(
				R.id.beyondarFragment);
		
		mRadarView = (RadarView) findViewById(R.id.radarView);
		mRadarModule = new RadarWorldModule();
		mRadarModule.setRadarView(mRadarView);

		// We create the world and fill it ...
		mWorld = CustomWorldHelper.generateObjects(this);
		// .. and send it to the fragment
		mBeyondarFragment.setWorld(mWorld);
		
		mWorld.addModule(mRadarModule);

		// We also can see the Frames per seconds
		mBeyondarFragment.showFPS(true);

	}

}