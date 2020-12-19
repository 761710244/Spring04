package cn.tuling.Model;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //  可以以字符串的形式注册多个Bean
        //  字符串必须是类的完整限定名
        return new String[]{"cn.tuling.Model.Person", "cn.tuling.Model.Wife"};
    }
}
