package com.tunjix.poplaroot.api.util;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/25 19:15
 */
final public class ClassDynamicUtil {

    public static byte[] getModifiedBytecode(Class<?> clazz) throws IOException {
        // 使用 ClassReader 读取原始类的字节码
        ClassReader classReader = new ClassReader(clazz.getName());
        // 创建一个 ClassWriter 来写入修改后的字节码
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        // 可以传入自定义的 ClassVisitor 进行字节码修改
        classReader.accept(classWriter, 0);
        // 获取修改后的字节码
        return classWriter.toByteArray();
    }
}
