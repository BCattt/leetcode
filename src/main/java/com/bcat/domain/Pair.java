package com.bcat.domain;

/**
 * 保存一组数据的Pair
 * @param <V1>
 * @param <V2>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class Pair<V1,V2> {
    public V1 v1;
    public V2 v2;
    public Pair(V1 v1, V2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}
