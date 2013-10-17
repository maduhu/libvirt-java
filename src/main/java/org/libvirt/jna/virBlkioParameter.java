package org.libvirt.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * JNA mapping for the virBlkioParameter structure
 */
public class virBlkioParameter extends Structure {
    public byte field[] = new byte[Libvirt.VIR_DOMAIN_BLKIO_FIELD_LENGTH];
    public int type;
    public virBlkioParameterValue value;

    private static final List fields = Arrays.asList(
            "field", "type", "value");

    @Override
    protected List getFieldOrder() {
        return fields;
    }
}
