package org.libvirt.jna;

import com.sun.jna.Union;

/**
 * JNA mapping for the virBlkioParameterValue structure
 */
public class virBlkioParameterValue extends Union {
    public int i; /* data for integer case */
    public long l; /* data for long long integer case */
    public double d; /* data for double case */
    public byte b; /* data for char case */
}
