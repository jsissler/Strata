/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.pricer.sensitivity;

import java.io.Serializable;
import java.time.LocalDate;
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

import com.google.common.collect.ComparisonChain;
import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.index.IborIndex;

/**
 * Point sensitivity to a rate from an Ibor index curve.
 * <p>
 * Holds the sensitivity to the {@link IborIndex} curve at a fixing date.
 */
@BeanDefinition
public final class IborRateSensitivity
    implements CurveSensitivity, ImmutableBean, Serializable {

  /**
   * The index of the curve for which the sensitivity is computed.
   */
  @PropertyDefinition(validate = "notNull")
  private final IborIndex index;
  /**
   * The currency of the sensitivity.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Currency currency;
  /**
   * The date that was looked up on the curve, which is the fixing date.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final LocalDate date;
  /**
   * The value of the sensitivity.
   */
  @PropertyDefinition(overrideGet = true)
  private final double sensitivity;

  //-------------------------------------------------------------------------
  /**
   * Obtains a {@code IborRateSensitivity} from the index, currency, fixing date and value.
   * 
   * @param index  the index of the curve
   * @param currency  the currency of the curve
   * @param fixingDate  the fixing date
   * @param sensitivity  the value of the sensitivity
   * @return the point sensitivity object
   */
  public static IborRateSensitivity of(IborIndex index, Currency currency, LocalDate fixingDate, double sensitivity) {
    return new IborRateSensitivity(index, currency, fixingDate, sensitivity);
  }

  //-------------------------------------------------------------------------
  @Override
  public Object getCurveKey() {
    return index;
  }

  @Override
  public IborRateSensitivity withSensitivity(double sensitivity) {
    return new IborRateSensitivity(index, currency, date, sensitivity);
  }

  @Override
  public int compareExcludingSensitivity(CurveSensitivity other) {
    if (other instanceof IborRateSensitivity) {
      IborRateSensitivity otherIbor = (IborRateSensitivity) other;
      return ComparisonChain.start()
          .compare(index.toString(), otherIbor.index.toString())
          .compare(currency, otherIbor.currency)
          .compare(date, otherIbor.date)
          .result();
    }
    return ComparisonChain.start()
        .compare(index.toString(), other.getCurveKey().toString())
        .result();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IborRateSensitivity}.
   * @return the meta-bean, not null
   */
  public static IborRateSensitivity.Meta meta() {
    return IborRateSensitivity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IborRateSensitivity.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static IborRateSensitivity.Builder builder() {
    return new IborRateSensitivity.Builder();
  }

  private IborRateSensitivity(
      IborIndex index,
      Currency currency,
      LocalDate date,
      double sensitivity) {
    JodaBeanUtils.notNull(index, "index");
    JodaBeanUtils.notNull(currency, "currency");
    JodaBeanUtils.notNull(date, "date");
    this.index = index;
    this.currency = currency;
    this.date = date;
    this.sensitivity = sensitivity;
  }

  @Override
  public IborRateSensitivity.Meta metaBean() {
    return IborRateSensitivity.Meta.INSTANCE;
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
   * Gets the index of the curve for which the sensitivity is computed.
   * @return the value of the property, not null
   */
  public IborIndex getIndex() {
    return index;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency of the sensitivity.
   * @return the value of the property, not null
   */
  @Override
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the date that was looked up on the curve, which is the fixing date.
   * @return the value of the property, not null
   */
  @Override
  public LocalDate getDate() {
    return date;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the value of the sensitivity.
   * @return the value of the property
   */
  @Override
  public double getSensitivity() {
    return sensitivity;
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
      IborRateSensitivity other = (IborRateSensitivity) obj;
      return JodaBeanUtils.equal(getIndex(), other.getIndex()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getDate(), other.getDate()) &&
          JodaBeanUtils.equal(getSensitivity(), other.getSensitivity());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getIndex());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash = hash * 31 + JodaBeanUtils.hashCode(getDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSensitivity());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("IborRateSensitivity{");
    buf.append("index").append('=').append(getIndex()).append(',').append(' ');
    buf.append("currency").append('=').append(getCurrency()).append(',').append(' ');
    buf.append("date").append('=').append(getDate()).append(',').append(' ');
    buf.append("sensitivity").append('=').append(JodaBeanUtils.toString(getSensitivity()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IborRateSensitivity}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code index} property.
     */
    private final MetaProperty<IborIndex> index = DirectMetaProperty.ofImmutable(
        this, "index", IborRateSensitivity.class, IborIndex.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", IborRateSensitivity.class, Currency.class);
    /**
     * The meta-property for the {@code date} property.
     */
    private final MetaProperty<LocalDate> date = DirectMetaProperty.ofImmutable(
        this, "date", IborRateSensitivity.class, LocalDate.class);
    /**
     * The meta-property for the {@code sensitivity} property.
     */
    private final MetaProperty<Double> sensitivity = DirectMetaProperty.ofImmutable(
        this, "sensitivity", IborRateSensitivity.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "index",
        "currency",
        "date",
        "sensitivity");

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
        case 575402001:  // currency
          return currency;
        case 3076014:  // date
          return date;
        case 564403871:  // sensitivity
          return sensitivity;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public IborRateSensitivity.Builder builder() {
      return new IborRateSensitivity.Builder();
    }

    @Override
    public Class<? extends IborRateSensitivity> beanType() {
      return IborRateSensitivity.class;
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
    public MetaProperty<IborIndex> index() {
      return index;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code date} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> date() {
      return date;
    }

    /**
     * The meta-property for the {@code sensitivity} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> sensitivity() {
      return sensitivity;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return ((IborRateSensitivity) bean).getIndex();
        case 575402001:  // currency
          return ((IborRateSensitivity) bean).getCurrency();
        case 3076014:  // date
          return ((IborRateSensitivity) bean).getDate();
        case 564403871:  // sensitivity
          return ((IborRateSensitivity) bean).getSensitivity();
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
   * The bean-builder for {@code IborRateSensitivity}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<IborRateSensitivity> {

    private IborIndex index;
    private Currency currency;
    private LocalDate date;
    private double sensitivity;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(IborRateSensitivity beanToCopy) {
      this.index = beanToCopy.getIndex();
      this.currency = beanToCopy.getCurrency();
      this.date = beanToCopy.getDate();
      this.sensitivity = beanToCopy.getSensitivity();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return index;
        case 575402001:  // currency
          return currency;
        case 3076014:  // date
          return date;
        case 564403871:  // sensitivity
          return sensitivity;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          this.index = (IborIndex) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case 3076014:  // date
          this.date = (LocalDate) newValue;
          break;
        case 564403871:  // sensitivity
          this.sensitivity = (Double) newValue;
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
    public IborRateSensitivity build() {
      return new IborRateSensitivity(
          index,
          currency,
          date,
          sensitivity);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code index} property in the builder.
     * @param index  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder index(IborIndex index) {
      JodaBeanUtils.notNull(index, "index");
      this.index = index;
      return this;
    }

    /**
     * Sets the {@code currency} property in the builder.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    /**
     * Sets the {@code date} property in the builder.
     * @param date  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder date(LocalDate date) {
      JodaBeanUtils.notNull(date, "date");
      this.date = date;
      return this;
    }

    /**
     * Sets the {@code sensitivity} property in the builder.
     * @param sensitivity  the new value
     * @return this, for chaining, not null
     */
    public Builder sensitivity(double sensitivity) {
      this.sensitivity = sensitivity;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("IborRateSensitivity.Builder{");
      buf.append("index").append('=').append(JodaBeanUtils.toString(index)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("date").append('=').append(JodaBeanUtils.toString(date)).append(',').append(' ');
      buf.append("sensitivity").append('=').append(JodaBeanUtils.toString(sensitivity));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
