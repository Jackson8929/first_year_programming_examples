package Chap17;
import Horses.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class FileHorse extends Horse implements Serializable
{

    public FileHorse(String[] saVals)
    {
        super(saVals);
    }

    //2nd Constructor
    public FileHorse()
    {
        this(new String[] {"","","0","","0"});
    }

    /**
     * Method that writes out attribute information to the file we are working with.
     * @param obOut
     * @throws IOException
     */
    public void writeEntry(DataOutputStream obOut) throws IOException
    {
        obOut.writeUTF(this.getName());
        obOut.writeUTF(this.getBreed());
        obOut.writeInt(this.getAge());
        obOut.writeUTF(this.getGender());
        obOut.writeInt(this.getSpeedFactor());
    }





}
