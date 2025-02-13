/*
 * Copyright 2020 Harness Inc. All rights reserved.
 * Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
 * that can be found in the licenses directory at the root of this repository, also available at
 * https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
 */

package io.harness.expression;

import java.util.HashMap;

public class LateBindingMap extends HashMap<String, Object> {
  @Override
  public synchronized Object get(Object key) {
    Object object = super.get(key);
    if (object instanceof LateBindingValue) {
      // Remove the late binding value to avoid endless loop
      remove(key);
      object = ((LateBindingValue) object).bind();
      put((String) key, object);
    }

    return object;
  }
}
