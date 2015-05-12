/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fasterxml.jackson;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类我目前可以知道的是 能够创建类的泛型的实例 感觉吊吊的
 * //why extra work? Java Type Erasure will prevent type detection otherwise
 * 做额外的工作是java类型擦除会阻止类型监测
 * 
 * ParameterizedType represents a parameterized type such as
 * Collection&lt;String&gt;.
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月21日 下午8:53:37
 * <p>Version: 1.0
 */
public abstract class TypeReference<T> {

    private final Type type;
    private volatile Constructor<?> constructor;

    protected TypeReference() {
    	//com.fasterxml.jackson.TypeReference<java.util.ArrayList<java.lang.String>>
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        //java.util.ArrayList<java.lang.String>
        this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }

    /**
     * Instantiates a new instance of {@code T} using the default, no-arg
     * constructor.
     */
    @SuppressWarnings("unchecked")
    public T newInstance()
            throws NoSuchMethodException, IllegalAccessException,
                   InvocationTargetException, InstantiationException {
        if (constructor == null) {//class java.util.ArrayList
            Class<?> rawType = type instanceof Class<?>
                ? (Class<?>) type //Returns the Type object representing the class or interface that declared this type.
                : (Class<?>) ((ParameterizedType) type).getRawType();
            constructor = rawType.getConstructor();
        }//public java.util.ArrayList()
        return (T) constructor.newInstance();
    }

    /**
     * Gets the referenced type.
     */
    public Type getType() {
        return this.type;
    }

    public static void main(String[] args) throws Exception {
        List<String> l1 = new TypeReference<ArrayList<String>>() {}.newInstance();
        List l2 = new TypeReference<ArrayList>() {}.newInstance();
    }
}
