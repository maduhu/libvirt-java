package org.libvirt;

/**
 * Parameter to hold an ulong.
 */
public final class BlkioUlongParameter extends BlkioParameter {
    /**
     * The parameter value
     */
    public long value;

    public BlkioUlongParameter() {

    }

    public BlkioUlongParameter(long value) {
        this.value = value;
    }

    public int getType() {
        return 4;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_ULLONG";
    }

    public String getValueAsString() {
        return Long.toString(value);
    }
}
