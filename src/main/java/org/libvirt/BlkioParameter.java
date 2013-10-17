package org.libvirt;

import java.util.Arrays;

import org.libvirt.jna.Libvirt;
import org.libvirt.jna.virBlkioParameter;
import org.libvirt.jna.virBlkioParameterValue;

import com.sun.jna.Native;

/**
 * The abstract parent of the actual BlkioParameter classes
 *
 * @author ynojima
 *
 */
public abstract class BlkioParameter {

    public static BlkioParameter create(virBlkioParameter vParam) {
        BlkioParameter returnValue = null;
        if (vParam != null) {
            switch (vParam.type) {
                case (1):
                    returnValue = new BlkioIntParameter(vParam.value.i);
                    break;
                case (2):
                    returnValue = new BlkioUintParameter(vParam.value.i);
                    break;
                case (3):
                    returnValue = new BlkioLongParameter(vParam.value.l);
                    break;
                case (4):
                    returnValue = new BlkioUlongParameter(vParam.value.l);
                    break;
                case (5):
                    returnValue = new BlkioDoubleParameter(vParam.value.d);
                    break;
                case (6):
                    returnValue = new BlkioBooleanParameter(vParam.value.b);
                    break;
            }
            returnValue.field = Native.toString(vParam.field);
        }
        return returnValue;
    }

    public static virBlkioParameter toNative(BlkioParameter param) {
        virBlkioParameter returnValue = new virBlkioParameter();
        returnValue.value = new virBlkioParameterValue();
        returnValue.field = copyOf(param.field.getBytes(), Libvirt.VIR_DOMAIN_BLKIO_FIELD_LENGTH);
        returnValue.type = param.getType();
        switch (param.getType()) {
            case (1):
                returnValue.value.i = ((BlkioIntParameter) param).value;
                returnValue.value.setType(int.class);
                break;
            case (2):
                returnValue.value.i = ((BlkioUintParameter) param).value;
                returnValue.value.setType(int.class);
                break;
            case (3):
                returnValue.value.l = ((BlkioLongParameter) param).value;
                returnValue.value.setType(long.class);
                break;
            case (4):
                returnValue.value.l = ((BlkioUlongParameter) param).value;
                returnValue.value.setType(long.class);
                break;
            case (5):
                returnValue.value.d = ((BlkioDoubleParameter) param).value;
                returnValue.value.setType(double.class);
                break;
            case (6):
                returnValue.value.b = (byte) (((BlkioBooleanParameter) param).value ? 1 : 0);
                returnValue.value.setType(byte.class);
                break;

        }
        return returnValue;
    }

    public static byte[] copyOf(byte[] original, int length) {
        byte[] returnValue = new byte[length];
        int originalLength = original.length ;
        Arrays.fill(returnValue, (byte)0);
        for (int x = 0 ; x < originalLength ; x++) {
            returnValue[x] = original[x] ;
        }
        return returnValue ;
    }

    /**
     * Parameter name
     */
    public String field;

    /**
     * The type of the parameter
     *
     * @return the Type of the parameter
     */
    public abstract int getType();

    /**
     * Utility function for displaying the type
     *
     * @return the Type of the parameter as string
     */
    public abstract String getTypeAsString();

    /**
     * Utility function for displaying the value
     *
     * @return the value of the parameter in String form
     */
    public abstract String getValueAsString();
}
