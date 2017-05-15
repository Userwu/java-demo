package com.zido.core.loader;

import com.zido.core.commons.AbstractNodeAction;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * parent.
 * Date: 2017/2/21 0021
 * Time: 15:43
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class LoadPlugins {
    private List<AbstractNodeAction> plugins = new ArrayList<>();
    private List<ClassLoader> loaders = new ArrayList<>();
    public void loadJar(String path){
        final JarFile jarFile;
        ClassLoader loader;
        try {
            jarFile = new JarFile(path);
            loader = new URLClassLoader(new URL[]{new File(path).toURI().toURL()});
            final Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()){
                final JarEntry jarEntry = entries.nextElement();
                String name = jarEntry.getName();
                if(name != null && name.endsWith(".class")){

                    final Class<?> pluginEntry = loader.loadClass(name.replace("/", ".").substring(0, name.length() - 6));
                    System.out.println(pluginEntry);
                    final Object o = pluginEntry.newInstance();
                    if(o instanceof AbstractNodeAction){
                        plugins.add((AbstractNodeAction) o);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("路径错误");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("类解析错误");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("实例化错误，你应该提供一个构造函数");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("实例化错误，你应该提供一个无参构造函数");
            e.printStackTrace();
        }

    }
    public void runPlugins(){
        for (AbstractNodeAction plugin : plugins) {
            plugin.run();
        }
    }

    public static void main(String[] args) {
        final LoadPlugins loadPlugins = new LoadPlugins();
        loadPlugins.loadJar("parent/lib/node-1.0.0.jar");
        loadPlugins.runPlugins();
    }
}
