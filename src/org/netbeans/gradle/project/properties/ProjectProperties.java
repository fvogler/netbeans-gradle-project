package org.netbeans.gradle.project.properties;

import java.nio.charset.Charset;
import java.util.Collection;
import org.netbeans.api.java.platform.JavaPlatform;

public interface ProjectProperties {
    public MutableProperty<String> getSourceLevel();
    public MutableProperty<JavaPlatform> getPlatform();
    public MutableProperty<Charset> getSourceEncoding();

    public Collection<MutableProperty<?>> getAllProperties();
}
