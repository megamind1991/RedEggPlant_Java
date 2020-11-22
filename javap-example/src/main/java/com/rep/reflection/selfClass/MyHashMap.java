package com.rep.reflection.selfClass;

import java.lang.annotation.Documented;
import java.util.HashMap;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Resource
public class MyHashMap extends HashMap<String, Object> {

    public static final int test=0;

}