package ev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ElectricVehicleTest {

  private ElectricVehicle tesla;

//      public ElectricVehicle(String name, double batterySize, double currentCharge,
//      double defaultEfficiencyBattery) {

  @BeforeEach

  /**
   * Creates a new instance of electric vehicle given EV's name, battery size, current charge and default efficiency battery
   * @param name the electric vehicle's name
   * @param batterySize the electric vehicle's battery size
   * @param currentCharge the electric vehicle's current charge
   * @param defaultEfficiencyBattery the electric vehicle's default efficiency battery
   */

  void setUp(){
    this.tesla = new ElectricVehicle("Tesla", 202.4,10,4.6);
  }

  /**
   * Test the range
   */

  @Test
  void range() {
    //currentEfficiencyBattery*currentCharge*batterySize;
    // = 4.5*1*150
    double range = 4.5*0.15*150;
    Assertions.assertEquals(range, this.tesla.range());
  }


  /*  public void updateEfficiency(double currentTemp){


    double diffTem = (TEM_MIN+1) - currentTemp;

    double reduceAmountPercentage;
    if ((currentTemp>TEM_MIN)&&(currentTemp<TEM_MAX)){
      this.currentEfficiencyBattery = WITHIN_TEM_PERCENTAGE*defaultEfficiencyBattery;
    } else if (currentTemp>TEM_MAX) {
      this.currentEfficiencyBattery=ABOVE_TEM_PERCENTAGE*defaultEfficiencyBattery;
    }else if (currentTemp<TEM_MIN){
      if(diffTem>DIFFTEM_MAX){
        this.currentEfficiencyBattery = REDUCE_AMOUNT_PERCENTAGE_MAX*defaultEfficiencyBattery;
      }else{
        this.currentEfficiencyBattery = ((TEM_MIN+1)-currentTemp)/100*defaultEfficiencyBattery;
      }
    }
  }*/

  /**
   * Test updateEfficiency
   */

  @Test

  void updateEfficiency() {
    double tem_above = 78.0;
    double currentEfficiencyBattery_above = 0.85*4.5;
    double tem_mid = 70;
    double currentEfficiencyBattery_mid = 0.1*4.5;
    double tem_below = 63;
    double currentEfficiencyBattery_below = ((65-tem_below)/100)*4.5;
    this.tesla.updateEfficiency(78);
    Assertions.assertEquals(3.8249999999999997,this.tesla.getCurrentEfficiencyBattery());
  }

  /**
   * Test getCurrentEfficiencyBattery
   */

  @Test
  void getCurrentEfficiencyBattery() {
    Assertions.assertEquals(4.5,this.tesla.getCurrentEfficiencyBattery());
  }

  /**
   * Test getBatterySize
   */

  @Test
  void getBatterySize() {
    Assertions.assertEquals(150, this.tesla.getBatterySize());
  }

  /**
   * Test getCurrentCharge
   */

  @Test
  void getCurrentCharge() {
    Assertions.assertEquals(15,this.tesla.getCurrentCharge());
  }

  /**
   * Test getName
   */

  @Test
  void getName() {
    Assertions.assertEquals("Tesla", this.tesla.getName());
  }

  /**
   * Test setCurrentCharge
   */

  @Test
  void setCurrentCharge() {
    tesla.setCurrentCharge(50); //0.5 //4
    Assertions.assertEquals(50,this.tesla.getCurrentCharge());
  }

  /**
   * Test testToString
   */

  @Test
  void testToString() {
    Assertions.assertEquals("Tesla: 15% Range (miles): 101.2" ,tesla.toString());
//        return (name + ": " + formatter.format(currentCharge) + "%% Range (miles): " + formatter.format(
//        range));
  }
}