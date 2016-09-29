/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.libraries.remixer;

/**
 * Convenience builder for Remix&lt;Boolean&gt; that assumes false to be the default value.
 */
public class BooleanRemixBuilder extends Remix.Builder<Boolean> {

  public BooleanRemixBuilder() {
    // Assume false to be the default value
    setDefaultValue(false);
  }

}