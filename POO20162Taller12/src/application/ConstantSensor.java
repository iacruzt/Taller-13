package application;

public class ConstantSensor implements Sensor
{

    private boolean online;
    private int reading;


    public ConstantSensor ()
    {
        // Default constructor here!
    }

    public ConstantSensor ( int initialReading )
    {
        this.online = true;
        this.reading = initialReading;
    }

    public boolean isOn ()
    {
        return this.online;
    }

    public void on ()
    {
        // Does nothing...
    }

    public void off ()
    {
        // Does nothing...
    }

    public int measure ()
    {
        int returnValue;

        if ( this.online == true )
        {
            returnValue = this.reading;
        }
        else
        {
            throw new IllegalStateException ( "There's no current reading since the sensor is off" );
        }

        return returnValue;
    }

}
