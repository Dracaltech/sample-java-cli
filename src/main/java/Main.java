package src.main.java;
import java.io.*;

public class Main {

  public static void main(String[] args)
  {
    Process usbGet;

    // Note: dracal-usb-get assumed to be in the path
    // Arguments passed to -i (0,1,2) here need to be updated to fit
    // your scenario. You may also specify a serial number by adding
    // the -s argument.
    try {
      usbGet = Runtime.getRuntime().exec("dracal-usb-get -i 0,1,2");
    } catch(IOException e) {
      System.err.println("could not run dracal-usb-get: " + e);
      return;
    }

    // Wait until the process exits
    while(true) {
      try {
        usbGet.waitFor();
      } catch (InterruptedException e) {
        continue;
      }
      break;
    }

    // Check if dracal-usb-get exited with an error code
    if (usbGet.exitValue() != 0) {
      System.err.println("dracal-usb-get error. Exit value=" + usbGet.exitValue());
      return;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(usbGet.getInputStream()));

    // dracal-usb-get outputs the data on the first line. Read it to a string.
    String line;
    try {
      line = reader.readLine();
    } catch (IOException e) {
      System.err.println("Error reading data: " + e);
      return;
    }

    // Now split the line in an array of values.
    String[] values = line.split(",");

    // Check that we received the expected number of fields (in this case,
    // the dracal-usb-get -i 0,1,2 argument requests 3 fields).
    if (values.length != 3) {
      System.err.println("Incorrect number of fields received: " + values.length);
      return;
    }

    float pressure = Float.parseFloat(values[0]);
    float temperature = Float.parseFloat(values[1]);
    float rh = Float.parseFloat(values[2]);

    System.out.println("Temperature (C):" + temperature);
    System.out.println("RH......... (%):" + rh);
    System.out.println("Pressure..(kPa):" + pressure);
    System.out.println("Temperature (C):" + (temperature*9/5+32));
  }
}