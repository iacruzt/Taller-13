package application;

public class Thermometer implements Sensor
{

    private boolean online;
    private int reading;


    public Thermometer ()
    {
        this.online = false;
    }

    public boolean isOn ()
    {
        return this.online;
    }

    public void on ()
    {
        this.online = true;
    }

    public void off ()
    {
        this.online = false;
    }

    public int measure ()
    {
        int returnValue;

        if ( this.online == true )
        {
            this.setReading ( (int)(Math.random() * (30 -(-30) + 1 )) + (-30) );
            returnValue = this.reading;
        }
        else
        {
            throw new IllegalStateException ( "There's no current reading since the sensor is off" );
        }

        return returnValue;
    }

    public int getReading()
    {
        return reading;
    }

    public void setReading(int reading)
    {
        this.reading = reading;
    }

}
