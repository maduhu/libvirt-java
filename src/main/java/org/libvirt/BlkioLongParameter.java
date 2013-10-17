package org.libvirt;

/**
 * Parameter to hold an long.
 */
public final class BlkioLongParameter extends BlkioParameter {
    /**
     * The parameter value
     */
    public long value;

    public BlkioLongParameter() {

    }

    public BlkioLongParameter(long value) {
        this.value = value;
    }

    public int getType() {
        return 3;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_LLONG";
    }

    public String getValueAsString() {
        return Long.toString(value);
    }

}
