package _new_old;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.eyzox._new.configoption.ConfigOption;
import fr.eyzox._new.configoption.IFastConfigEditor;

/**
 *
 */
public class ConfigSerializerBuilder<R, W> {

    private final Map<Class<?>, ISerializer<R, W, ?>> serializers = new HashMap<Class<?>, ISerializer<R, W, ?>>();

    public ConfigProvider<R, W> build(Collection<ConfigOptionGroup> c) {
        ConfigProvider<R, W> cp = new ConfigProvider<R, W>();

        for(ConfigOptionGroup cog : c) {
            for(ConfigOption<?> co : cog.getConfigOptions()) {

                final ISerializer<R, W, ?> serial = serializers.get(co.getValue().getClass());
                if(serial == null) {
                    throw new NoSerializerException(co);
                }

                cp.register(co,serial, (co instanceof IFastConfigUpdater ? (IFastConfigUpdater) co : null));
            }
        }

        return cp;
    }

    public <T> void register(Class<T> clazz, ISerializer<R, W, T> serializer) {
        this.serializers.put(clazz, serializer);
    }

    public void unregister(Class<?> clazz) {
        this.serializers.remove(clazz);
    }
}