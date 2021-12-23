package com.service.adapter;

import com.service.adapter.service.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

  @Autowired
  private CalculatorService calculatorService;

  @Test
  public void addTest() {
    Assert.assertEquals(120, calculatorService.add(100, 20));
  }

  @Test
  public void divideTest() {
    Assert.assertEquals(3, calculatorService.divide(90, 30));
  }

  @Test
  public void multiplyTest() {
    Assert.assertEquals(100, calculatorService.multiply(50, 2));
  }

  @Test
  public void subtractTest() {
    Assert.assertEquals(15, calculatorService.subtract(25, 10));
  }
}
