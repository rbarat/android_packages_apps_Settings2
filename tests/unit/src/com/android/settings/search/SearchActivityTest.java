/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.settings.search;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.android.settings.Settings;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SmallTest
@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    @Test
    public void shouldHaveParentActivity() {
        final Context context = InstrumentationRegistry.getTargetContext();
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(context, SearchActivity.class);
        final List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(
                intent, PackageManager.GET_META_DATA);

        assertThat(resolveInfos).isNotEmpty();
        assertThat(resolveInfos.get(0).activityInfo.parentActivityName)
                .isEqualTo(Settings.class.getName());
    }
}
