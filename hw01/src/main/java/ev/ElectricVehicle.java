package ev;

import java.text.NumberFormat;

/**
 * Represents an ElectricVehicle with their details--name, battery size, current charge,
 *    current efficiency of battery， default efficiency of battery and default efficiency
 *
 @author author
 */

public class ElectricVehicle {

  private String name;
  private double batterySize;

  private double currentCharge;

  private double currentEfficiencyBattery;

  private double defaultEfficiencyBattery;


  static final int BATTERY_SIZE_MIN = 10;
  static final int BATTERY_SIZE_MAX = 150;

  static final double DEFAULT_EFFICIENCY_BATTERY_MIN = 0.5;
  static final double DEFAULT_EFFICIENCY_BATTERY_MAX = 4.5;

  static final double CURRENT_CHARGE_MIN = 15;
  static final double CURRENT_CHARGE_MAX = 100;

  static final double TEM_MIN = 64.0;
  static final double TEM_MAX = 77.0;
  static final double WITHIN_TEM_PERCENTAGE = 1.00;
  static final double ABOVE_TEM_PERCENTAGE = 0.85;
  static final double DIFFTEM_MAX = 50;
  static final double REDUCE_AMOUNT_PERCENTAGE_MAX = 0.5;

  /**
   * Creates a new electric vehicle given EV's name, battery size, current charge and default efficiency battery
   * @param name the electric vehicle's name
   * @param batterySize the electric vehicle's battery size
   * @param currentCharge the electric vehicle's current charge
   * @param defaultEfficiencyBattery the electric vehicle's default efficiency battery
   */

  public ElectricVehicle(String name, double batterySize, double currentCharge,
      double defaultEfficiencyBattery) {

    // current efficiency battery
    //    this.currentEfficiencyBattery = defaultEfficiencyBattery;

    if (defaultEfficiencyBattery < DEFAULT_EFFICIENCY_BATTERY_MIN) {
      this.currentEfficiencyBattery = DEFAULT_EFFICIENCY_BATTERY_MIN;
    } else if (defaultEfficiencyBattery > DEFAULT_EFFICIENCY_BATTERY_MAX) {
      this.currentEfficiencyBattery = DEFAULT_EFFICIENCY_BATTERY_MAX;
    } else {
      this.currentEfficiencyBattery = defaultEfficiencyBattery;
    }


    // name

    if ((name.equals(null)) || (name.equals(""))) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

//    battery size

    if (batterySize < BATTERY_SIZE_MIN) {
      this.batterySize = BATTERY_SIZE_MIN;
    } else if (batterySize > BATTERY_SIZE_MAX) {
      this.batterySize = BATTERY_SIZE_MAX;
    } else {
      this.batterySize = batterySize;
    }

//    default efficiency

    if (defaultEfficiencyBattery < DEFAULT_EFFICIENCY_BATTERY_MIN) {
      this.defaultEfficiencyBattery = DEFAULT_EFFICIENCY_BATTERY_MIN;
    } else if (defaultEfficiencyBattery > DEFAULT_EFFICIENCY_BATTERY_MAX) {
      this.defaultEfficiencyBattery = DEFAULT_EFFICIENCY_BATTERY_MAX;
    } else {
      this.defaultEfficiencyBattery = defaultEfficiencyBattery;
    }

//    current charge

    if (currentCharge < CURRENT_CHARGE_MIN) {
      this.currentCharge = CURRENT_CHARGE_MIN;
    } else if (currentCharge > CURRENT_CHARGE_MAX) {
      this.currentCharge = CURRENT_CHARGE_MAX;
    } else {
      this.currentCharge = currentCharge;
    }

  }

  /**
   * @return the electric vehicle's range = current efficiency of battery * current charge * battery
   * size
   */
  public double range() {

    double range = currentEfficiencyBattery * (currentCharge/100) * batterySize;

    NumberFormat formatter = NumberFormat.getInstance();
    formatter.setMaximumFractionDigits(1);
    formatter.format(range);

    return range;
  }

  /**
   * @param currentTemp current temperature that the electric vehicle is in
   */

  public void updateEfficiency(double currentTemp) {

    double diffTem = (TEM_MIN + 1) - currentTemp;

    double reduceAmountPercentage;
    if ((currentTemp > TEM_MIN) && (currentTemp < TEM_MAX)) {
      this.currentEfficiencyBattery = WITHIN_TEM_PERCENTAGE * defaultEfficiencyBattery;
    } else if (currentTemp > TEM_MAX) {
      this.currentEfficiencyBattery = ABOVE_TEM_PERCENTAGE * defaultEfficiencyBattery;
    } else if (currentTemp < TEM_MIN) {
      if (diffTem > DIFFTEM_MAX) {
        this.currentEfficiencyBattery = REDUCE_AMOUNT_PERCENTAGE_MAX * defaultEfficiencyBattery;
      } else {
        this.currentEfficiencyBattery =
            ((TEM_MIN + 1) - currentTemp) / 100 * defaultEfficiencyBattery;
      }
    }
  }

  /**
   * @return current efficiency of battery
   */
  public double getCurrentEfficiencyBattery() {
    NumberFormat formatter = NumberFormat.getInstance();
    formatter.setMaximumFractionDigits(1);
    formatter.format(currentEfficiencyBattery);
    return currentEfficiencyBattery;
  }


  /**
   * @return battery size
   */
  public double getBatterySize() {
    return batterySize;
  }

  /**
   * @return current charge
   */

  public double getCurrentCharge() {
    return currentCharge;
  }

  /**
   * @return name
   */


  public String getName() {
    return name;
  }

  /**
   * Sets the electric vehicle’s current charge
   *
   * @param currentCharge the electric vehicle's current charge
   */

  public void setCurrentCharge(double currentCharge) {
    if (currentCharge < CURRENT_CHARGE_MIN) {
      this.currentCharge = CURRENT_CHARGE_MIN;
    } else if (currentCharge > CURRENT_CHARGE_MAX) {
      this.currentCharge = CURRENT_CHARGE_MAX;
    } else {
      this.currentCharge = currentCharge;
    }
  }

  public String toString() {
    double range = range();

    NumberFormat formatter = NumberFormat.getInstance();
    formatter.setMaximumFractionDigits(1);
    return (name + ": " + formatter.format(currentCharge) + "% Range (miles): " + formatter.format(
        range));
  }
}

//    double range = range();
//
//    String output = String.format(("%s: %。1f%% Range (miles): %.1f\n"),name,currentCharge,range);
//    return output;

//  public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }





