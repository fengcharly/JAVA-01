package jvm;


import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloClassLoader extends ClassLoader {


    public static void main(String[] args) throws Exception {
        // 这个地方的那么实际上是类的全限定名 是根据编译当时类型的位置路径来决定的
        // 如果我编译的Hello类是放在package jvm 中的,解析的时候就要写成jvm.Hello
        Class<?> clazz = new HelloClassLoader().findClass("Hello");
        Method hello = clazz.getDeclaredMethod("hello");
        hello.invoke(clazz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) {

        String HelloBase64 = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+" +
                "//CzlpGasYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4" +
                "/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpuajd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY" +
                "0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaRi6yLjZqeksT+" +
                "/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e" +
                "//r/+f///////f/+//j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0" +
                "//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1////9f/9////+//3//r//v/z/////f/y";

        byte[] bytes = decode(HelloBase64);
        // 对字节码进行处理
        // x = 255 - x
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }


    /**
     * 或者读取文件流的方式
     */
    public Class<?> readFromFile(String name) throws Exception {

        String path = "E:\\intellij05\\home-work\\src\\main\\java\\jvm\\Hello.xlass";

        FileInputStream fin = new FileInputStream(new File(path));

        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
