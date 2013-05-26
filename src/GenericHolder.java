import com.sun.deploy.util.SyncFileAccess;

import java.io.*;

public class GenericHolder<T extends Object>{

    private T obj;

    public GenericHolder(){}

    public void setObj(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return obj;
    }
}

