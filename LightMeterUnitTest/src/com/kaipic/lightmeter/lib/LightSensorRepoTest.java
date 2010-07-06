package com.kaipic.lightmeter.lib;

import android.content.Context;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class LightSensorRepoTest {
  @Test
  public void shouldCreateAmbientLightSensorForTypeAuto() throws Exception {
    Context context = mock(Context.class);
    LightSensorRepo repo = new LightSensorRepo(context);
    LightSensor sensor = repo.createSensor(LightSensorType.AUTO);
    assertTrue(sensor instanceof AmbientLightSensor);
  }

  @Test
  public void shouldCreateManualLightSensorForTypeManual() throws Exception {
    LightSensorRepo repo = new LightSensorRepo(null);
    LightSensor sensor = repo.createSensor(LightSensorType.MANUAL);
    assertTrue(sensor instanceof ManualLightSensor);    
  }

}
