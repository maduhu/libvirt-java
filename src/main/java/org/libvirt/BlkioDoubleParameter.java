package org.libvirt;

/**
 * Parameter to hold an double.
 */
public final class BlkioDoubleParameter extends BlkioParameter {
    /**
     * The parameter value
     */
    public double value;

    public BlkioDoubleParameter() {

    }

    public BlkioDoubleParameter(double value) {
        this.value = value;
    }

    public int getType() {
        return 5;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_DOUBLE";
    }

    public String getValueAsString() {
        return Double.toString(value);
    }
}
