package application;

import java.util.ArrayList;

public class AverageSensor implements Sensor
{

    private ArrayList < Sensor > sensors;
    private boolean online;
    private int reading;
    private ArrayList < Integer > readings;


    public AverageSensor ()
    {
        this.sensors = new ArrayList < Sensor > ();
        this.readings = new ArrayList < Integer > ();
    }

    public void addSensor ( Sensor newSensor )
    {
        this.sensors.add ( newSensor );
    }

    public boolean isOn ()
    {
        return this.online;
    }

    public void on ()
    {
        for ( Sensor s : this.sensors )
        {
            s.on();
        }
        this.online = true;
    }

    public void off ()
    {
        for ( Sensor s : this.sensors )
        {
            s.off();
        }
        this.online = false;
    }

    public int measure ()
    {
        int returnValue;

        if ( ( this.online == true ) && ( !this.sensors.isEmpty() ) )
        {
            returnValue = 0;
            for ( Sensor s : this.sensors )
            {
                returnValue = returnValue + s.measure();
            }
            returnValue = returnValue / this.sensors.size();
            this.recordMeasurement ( returnValue );
        }
        else
        {
            throw new IllegalStateException ( "There's no current reading since the sensor is off or empty" );
        }

        return returnValue;
    }

    public void recordMeasurement ( int newMeasurement )
    {
        this.readings.add ( newMeasurement );
    }

    public ArrayList < Integer > readings ()
    {
        return this.readings;
    }

}
