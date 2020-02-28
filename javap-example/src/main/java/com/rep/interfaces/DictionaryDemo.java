package com.rep.interfaces;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * 使用seriviceload 加载服务类
 */
public class DictionaryDemo {

    public static void main(String[] args) {

        // 获取字典服务
        DictionaryService dictionary = DictionaryService.getInstance();

        System.out.println(DictionaryDemo.lookup(dictionary, "book"));
        System.out.println(DictionaryDemo.lookup(dictionary, "editor"));
        System.out.println(DictionaryDemo.lookup(dictionary, "xml"));
        System.out.println(DictionaryDemo.lookup(dictionary, "REST"));
    }/* w ww. j a v a 2 s . c o m */

    public static String lookup(DictionaryService dictionary, String word) {
        String outputString = word + ": ";
        String definition = dictionary.getDefinition(word);
        if (definition == null) {
            return outputString + "Cannot find definition for this word.";
        }
        else {
            return outputString + definition;
        }
    }
}

class DictionaryService {

    private static DictionaryService service;

    private ServiceLoader<Dictionary> loader;

    private DictionaryService() {
        // 要用public的实现对象类才行
        loader = ServiceLoader.load(Dictionary.class);
    }

    public static synchronized DictionaryService getInstance() {
        // 并发获取字典服务实例 实例初期化的时候 进行serviecload 载入多个类型的字典
        if (service == null) {
            service = new DictionaryService();
        }
        return service;
    }

    public String getDefinition(String word) {
        String definition = null;

        try {
            Iterator<Dictionary> dictionaries = loader.iterator();
            while (definition == null && dictionaries.hasNext()) {
                Dictionary d = dictionaries.next();
                definition = d.getDefinition(word);
            }
        }
        catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();

        }
        return definition;
    }
}

interface Dictionary {
    public String getDefinition(String word);
}

/**
 * @author John O'Conner
 */
class ExtendedDictionary implements Dictionary {

    // private SortedMap<String, String> map = new TreeMap<String, String>();

    /**
     * Creates a new instance of ExtendedDictionary
     */
    // public ExtendedDictionary() {
    // map = new TreeMap<String, String>();
    // map.put("xml", "a document standard often used in web services, among other " + "things");
    // map.put("REST",
    // "an architecture style for creating, reading, updating, "
    // + "and deleting data that attempts to use the common "
    // + "vocabulary of the HTTP protocol; Representational State " + "Transfer");
    // }

    @Override
    public String getDefinition(String word) {
        // return map.get(word);
        return "X";
    }

}