package org.libvirt;

/**
 * Parameter to hold an boolean.
 */
public final class BlkioBooleanParameter extends BlkioParameter {
    /**
     * The parameter value
     */
    public boolean value;

    public BlkioBooleanParameter() {

    }

    public BlkioBooleanParameter(boolean value) {
        this.value = value;
    }

    public BlkioBooleanParameter(byte value) {
        this.value = ((value) != 0) ? true : false;
    }

    public int getType() {
        return 6;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_BOOLEAN";
    }

    public String getValueAsString() {
        return Boolean.toString(value);
    }
}
