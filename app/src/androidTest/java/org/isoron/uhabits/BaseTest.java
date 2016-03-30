/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits;

import android.content.Context;
import android.os.Looper;
import android.support.test.InstrumentationRegistry;

import org.isoron.uhabits.tasks.BaseTask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseTest
{
    protected Context testContext;
    protected Context targetContext;
    private static boolean isLooperPrepared;

    protected void setup()
    {
        if(!isLooperPrepared)
        {
            Looper.prepare();
            isLooperPrepared = true;
        }

        targetContext = InstrumentationRegistry.getTargetContext();
        testContext = InstrumentationRegistry.getContext();
    }

    protected void waitForAsyncTasks() throws InterruptedException, TimeoutException
    {
        BaseTask.waitForTasks(30, TimeUnit.SECONDS);
    }
}
