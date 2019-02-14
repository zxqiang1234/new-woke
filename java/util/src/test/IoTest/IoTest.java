package test.IoTest;

import javolution.io.Struct;

import java.nio.ByteOrder;


public class IoTest extends Struct {


    public final Float64 inTestId=new Float64();

    public final Float64   time=new Float64();
    public final Float64   load=new Float64();
    public final Float64   posi=new Float64();
    public final Float64   extn=new Float64();
    public final Float64   extes=new Float64();
    public final Float64   exterss=new Float64();

    @Override
    public boolean isPacked() {
        return true;
    }

    // 设置为小端数据
    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }

}
