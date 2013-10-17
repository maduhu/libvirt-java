package org.libvirt;

/**
 * Parameter to hold an uint.
 */
public final class BlkioUintParameter extends BlkioParameter {
    /**
     * The parameter value
     */
    public int value;

    public BlkioUintParameter() {

    }

    public BlkioUintParameter(int value) {
        this.value = value;
    }

    public int getType() {
        return 2;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_UINT";
    }

    public String getValueAsString() {
        return Integer.toString(value);
    }
}
