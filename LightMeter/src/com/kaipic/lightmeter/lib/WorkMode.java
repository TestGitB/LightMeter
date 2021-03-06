package com.kaipic.lightmeter.lib;

public abstract class WorkMode {
  protected LightMeter lightMeter;

  public WorkMode(LightMeter lightMeter) {
    this.lightMeter = lightMeter;
  }

  public boolean isApertureChangeable() {
    return true;
  }

  public boolean isShutterSpeedChangeable() {
    return true;
  }

  public boolean isExposureValueChangeable() {
    return true;
  }

  public ShutterSpeed getShutterSpeed() {
    return lightMeter.getShutterSpeed();
  }

  public void setShutterSpeed(ShutterSpeed shutterSpeed) {
    lightMeter.setShutterSpeed(shutterSpeed);
  }

  public void setAperture(Aperture aperture) {
    lightMeter.setAperture(aperture);
  }

  public Aperture getAperture() {
    return lightMeter.getAperture();
  }

  public ExposureValue getExposure() {
    return lightMeter.getISO100EV();
  }

  public String getLightValueString() {
    if(lightMeter.getLightSensor().isReady())
      return getExposure().toDetailString();
    else
      return lightMeter.getLightSensor().getStatus();

  }
}
