package org.libvirt;

/**
 * Parameter to hold an int.
 */
public final class BlkioIntParameter extends BlkioParameter {
    public int value;

    public BlkioIntParameter() {

    }

    public BlkioIntParameter(int value) {
        this.value = value;
    }

    public int getType() {
        return 1;
    }

    public String getTypeAsString() {
        return "VIR_DOMAIN_BLKIO_FIELD_INT";
    }

    public String getValueAsString() {
        return Integer.toString(value);
    }
}
