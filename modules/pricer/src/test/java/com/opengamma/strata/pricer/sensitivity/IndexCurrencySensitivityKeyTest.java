/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.pricer.sensitivity;

import static com.opengamma.strata.basics.currency.Currency.EUR;
import static com.opengamma.strata.basics.currency.Currency.GBP;
import static com.opengamma.strata.basics.index.IborIndices.USD_LIBOR_3M;
import static com.opengamma.strata.basics.index.IborIndices.EUR_EURIBOR_12M;
import static com.opengamma.strata.collect.TestHelper.coverBeanEquals;
import static com.opengamma.strata.collect.TestHelper.coverImmutableBean;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.strata.basics.index.IborIndex;

/**
 * Test {@link NameCurrencySensitivityKey}.
 */
@Test
public class IndexCurrencySensitivityKeyTest {

  private static final IborIndex INDEX = USD_LIBOR_3M;

  public void test_of() {
    IndexCurrencySensitivityKey test = IndexCurrencySensitivityKey.of(INDEX, EUR);
    assertEquals(test.getIndex(), INDEX);
    assertEquals(test.getCurrency(), EUR);
  }

  public void coverage() {
    IndexCurrencySensitivityKey test = IndexCurrencySensitivityKey.of(INDEX, EUR);
    coverImmutableBean(test);
    IndexCurrencySensitivityKey test2 = IndexCurrencySensitivityKey.of(EUR_EURIBOR_12M, GBP);
    coverBeanEquals(test, test2);
  }

}
