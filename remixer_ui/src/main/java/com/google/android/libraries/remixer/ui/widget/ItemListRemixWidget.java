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

package com.google.android.libraries.remixer.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.libraries.remixer.ItemListRemix;
import com.google.android.libraries.remixer.ui.R;

import java.util.List;

/**
 * Displays an ItemListRemix as a Spinner. The list uses item.toString() to display it as text.
 */
public class ItemListRemixWidget extends RelativeLayout
    implements RemixerItemWidget<ItemListRemix<?>> {

  private TextView nameText;
  private Spinner spinner;
  private List<?> values;

  public ItemListRemixWidget(Context context) {
    super(context);
  }

  public ItemListRemixWidget(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ItemListRemixWidget(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    spinner = (Spinner) findViewById(R.id.itemListRemixSpinner);
    nameText = (TextView) findViewById(R.id.itemListRemixName);
  }

  @Override
  public void bindRemixerItem(@NonNull final ItemListRemix remix) {
    values = remix.getValueList();
    int position = values.indexOf(remix.getSelectedValue());
    nameText.setText(remix.getTitle());
    spinner.setAdapter(
        new ArrayAdapter<>(getContext(), R.layout.item_list_spinner_view, values));
    spinner.setSelection(position);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      @SuppressWarnings("unchecked")
      public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        remix.setValue(values.get(pos));
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });
  }
}