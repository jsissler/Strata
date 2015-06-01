/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.function.marketdata.scenarios.curves;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.analytics.financial.model.interestrate.curve.YieldCurve;
import com.opengamma.strata.basics.index.RateIndex;
import com.opengamma.strata.engine.marketdata.scenarios.MarketDataFilter;
import com.opengamma.strata.market.curve.Curve;
import com.opengamma.strata.market.id.RateIndexCurveId;

/**
 * A market data filter matching a curve for a rate index.
 */
@BeanDefinition
public final class CurveRateIndexFilter implements MarketDataFilter<Curve, RateIndexCurveId>, ImmutableBean {

  /** The curve index. */
  @PropertyDefinition(validate = "notNull")
  private final RateIndex index;

  /**
   * Returns a filter matching a curve for the specified index.
   *
   * @param index  the index
   * @return a filter matching a curve for the specified index
   */
  public static CurveRateIndexFilter of(RateIndex index) {
    return new CurveRateIndexFilter(index);
  }

  @Override
  public boolean apply(RateIndexCurveId marketDataId, Curve curve) {
    return index.equals(marketDataId.getIndex());
  }

  @Override
  public Class<?> getMarketDataIdType() {
    return YieldCurve.class;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CurveRateIndexFilter}.
   * @return the meta-bean, not null
   */
  public static CurveRateIndexFilter.Meta meta() {
    return CurveRateIndexFilter.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CurveRateIndexFilter.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CurveRateIndexFilter.Builder builder() {
    return new CurveRateIndexFilter.Builder();
  }

  private CurveRateIndexFilter(
      RateIndex index) {
    JodaBeanUtils.notNull(index, "index");
    this.index = index;
  }

  @Override
  public CurveRateIndexFilter.Meta metaBean() {
    return CurveRateIndexFilter.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the curve index.
   * @return the value of the property, not null
   */
  public RateIndex getIndex() {
    return index;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CurveRateIndexFilter other = (CurveRateIndexFilter) obj;
      return JodaBeanUtils.equal(getIndex(), other.getIndex());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getIndex());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("CurveRateIndexFilter{");
    buf.append("index").append('=').append(JodaBeanUtils.toString(getIndex()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CurveRateIndexFilter}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code index} property.
     */
    private final MetaProperty<RateIndex> index = DirectMetaProperty.ofImmutable(
        this, "index", CurveRateIndexFilter.class, RateIndex.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "index");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return index;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CurveRateIndexFilter.Builder builder() {
      return new CurveRateIndexFilter.Builder();
    }

    @Override
    public Class<? extends CurveRateIndexFilter> beanType() {
      return CurveRateIndexFilter.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code index} property.
     * @return the meta-property, not null
     */
    public MetaProperty<RateIndex> index() {
      return index;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return ((CurveRateIndexFilter) bean).getIndex();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CurveRateIndexFilter}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CurveRateIndexFilter> {

    private RateIndex index;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CurveRateIndexFilter beanToCopy) {
      this.index = beanToCopy.getIndex();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return index;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          this.index = (RateIndex) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public CurveRateIndexFilter build() {
      return new CurveRateIndexFilter(
          index);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code index} property in the builder.
     * @param index  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder index(RateIndex index) {
      JodaBeanUtils.notNull(index, "index");
      this.index = index;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("CurveRateIndexFilter.Builder{");
      buf.append("index").append('=').append(JodaBeanUtils.toString(index));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
