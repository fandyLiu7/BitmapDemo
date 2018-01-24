package com.fandy.bitmapdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.View;

import java.util.Iterator;
import java.util.Map;

public class SecondActivity extends Activity {

    /**
     * 1,内部的数据结构使用的是双向链表来实现的
     * 2,当我们有访问操作的时候,被访问的节点将会移到链表的前边
     * 3,在LruCache的put,get,remove方法中,对集合操作时采用了synchronized关键字,用来保证线程的安全
     * <p>
     * LinkHashMap:两种顺序
     * 1:数据插入的顺序
     * 2:数据操作的顺序
     */
    private LruCache<String, String> mLruCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mLruCache = new LruCache<>(4);
        mLruCache.put("a", "这是第一个放进去的值");
        mLruCache.put("b", "这是第二个放进去的值");
        mLruCache.put("c", "这是第三个放进去的值");
        mLruCache.put("d", "这是第四个放进去的值");
        //这样操作之后,c将会挪到队列的最后边
        mLruCache.get("c");
        //这样进行操作之后,a这个最近最少使用的数据将会被清除出去
        mLruCache.put("e", "这是第五个放进去的值");
        //操作之后,key为c的数据将被删除,但是不会改变数据的顺序
        mLruCache.remove("c");
    }


    public void test(View view) {
        Map<String, String> map = mLruCache.snapshot();
        Iterator<String> iterator = map.keySet().iterator();
        String key;
        while (iterator.hasNext()) {
            key = iterator.next();
            System.out.println("LruCacheItem " + ",key=" + key + "     value=" + map.get(key));

        }
    }
}
